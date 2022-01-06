package com.booksmart.utility;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailConstructor {
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException {

        String from = "";

        // 1 - Get a mail session
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.mail.yahoo.com");
        properties.put("mail.smtps.port", 465);
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);

        // 2 - Create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // 3 - Address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - Send the message
        Transport transport = session.getTransport();
        transport.connect(from, "");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
