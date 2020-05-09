package com.application.service;

import com.application.model.MailModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    static public String  SendMessage(MailModel mailModel) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("lpgmy@yandex.ru",
                                "8y6ENFA7pruKRWw");
                    }
                });
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("lpgmy@yandex.ru"));
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(mailModel.getMail()));
            message.setSubject(mailModel.getSubject());
            message.setText(mailModel.getText());
            Transport.send(message);

        }
        catch (MessagingException ex) {
            ex.printStackTrace();
            return "404";
        }
        return "infoOfMessage";
    }
}
