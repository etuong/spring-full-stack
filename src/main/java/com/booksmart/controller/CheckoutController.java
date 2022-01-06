package com.booksmart.controller;

import com.booksmart.entity.CartItem;
import com.booksmart.entity.Order;
import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;
import com.booksmart.service.CartItemService;
import com.booksmart.service.OrderService;
import com.booksmart.service.ShoppingCartService;
import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/checkout")
    public String checkout(
            @RequestParam("id") Long cartId,
            Model model, Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());

        if (cartId != user.getShoppingCart().getId()) {
            return "404";
        }

        ShoppingCart shoppingCart = user.getShoppingCart();
        model.addAttribute("shoppingCart", shoppingCart);

        return "checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkoutPost(HttpSession session, Principal principal, Model model) throws Exception {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
        model.addAttribute("cartItemList", cartItemList);

        Order order = orderService.createOrder(shoppingCart, user);

        org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
        context.setVariable("order", order);
        context.setVariable("user", user);
        context.setVariable("cartItemList", order.getCartItemList());
        String confirmationHTML = templateEngine.process("orderConfirmationEmailTemplate", context);

        MailConstructor.sendMail(user.getEmail(), "BookSmart - Order Confirmation", confirmationHTML, true);

        shoppingCartService.clearShoppingCart(shoppingCart);

        LocalDate today = LocalDate.now();
        LocalDate estimatedDeliveryDate = today.plusDays(3);

        model.addAttribute("estimatedDeliveryDate", estimatedDeliveryDate);
        model.addAttribute("emailAddress", user.getEmail());

        session.setAttribute("cartLength", 0);
        session.setAttribute("confirmationhtml", confirmationHTML);

        return "orderConfirmation";
    }

    @RequestMapping("/generatePDF")
    public void generatePDF(HttpSession session, HttpServletResponse response) throws Exception {
        String confirmationHTML = (String) session.getAttribute("confirmationhtml");

        Document document = Jsoup.parse(confirmationHTML);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(document.html());
        renderer.layout();

        // Stream the generated PDF to the client
        OutputStream out = response.getOutputStream();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=BookSmart_Order_Confirmation.pdf");

        renderer.createPDF(out);
        out.flush();
        out.close();
    }
}
