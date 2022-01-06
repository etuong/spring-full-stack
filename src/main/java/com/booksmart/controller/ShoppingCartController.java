package com.booksmart.controller;

import com.booksmart.entity.Book;
import com.booksmart.entity.CartItem;
import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;
import com.booksmart.service.BookService;
import com.booksmart.service.CartItemService;
import com.booksmart.service.ShoppingCartService;
import com.booksmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BookService bookService;

    @GetMapping()
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCart = shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("username", principal.getName());
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("cart", shoppingCart);
        model.addAttribute("isEmpty", cartItemList == null || cartItemList.size() == 0);

        return "shoppingCart";
    }

    @RequestMapping("/addSingleItem")
    public String addItem1(
            HttpSession session,
            @PathParam("bookId") Long bookId,
            Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        Book book = bookService.findOne(bookId);
        cartItemService.addBookToCartItem(book, user, 1);
        int cartLength = cartItemService.getNumberOfCartItems(user);
        session.setAttribute("cartLength", cartLength);

        return "redirect:/shop";
    }

    @RequestMapping("/addItem")
    public String addItem2(
            HttpSession session,
            @ModelAttribute("book") Book book,
            @ModelAttribute("quantity") String quantity,
            Model model, Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        book = bookService.findOne(book.getId());
        int qty = quantity != null ? Integer.parseInt(quantity) : 1;
        cartItemService.addBookToCartItem(book, user, qty);
        int cartLength = cartItemService.getNumberOfCartItems(user);
        session.setAttribute("cartLength", cartLength);
        model.addAttribute("addBookSuccess", true);

        return "forward:/book?id=" + book.getId();
    }

    @RequestMapping("/updateCartItem")
    public String updateshoppingCart(
            @ModelAttribute("id") Long cartItemId,
            @ModelAttribute("quantity") int quantity
    ) {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setQuantity(quantity);
        cartItemService.updateCartItem(cartItem);

        return "forward:/shoppingCart";
    }

    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") Long id, HttpSession session, Principal principal) {
        cartItemService.removeCartItem(cartItemService.findById(id));
        User user = userService.findByUsername(principal.getName());
        int cartLength = cartItemService.getNumberOfCartItems(user);
        session.setAttribute("cartLength", cartLength);

        return "forward:/shoppingCart";
    }
}