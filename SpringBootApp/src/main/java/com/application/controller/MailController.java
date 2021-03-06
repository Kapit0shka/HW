package com.application.controller;

import com.application.model.MailModel;
import com.application.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @GetMapping("/sendMessage")
    public String creteFormSendMail(Model model) {
        MailModel mailModel = new MailModel();
        model.addAttribute("mailModel",mailModel);
        return "sendMessage";
    }

    @PostMapping("/sendMessage")
<<<<<<< HEAD
    public String sendMessage(@ModelAttribute MailModel mailModel) {
        return MailService.SendMessage(mailModel);
=======
    public String sendMessage(@ModelAttribute MailModel mailModel) throws MessagingException {
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
                                "************");
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
        }

        return "infoOfMessage";
>>>>>>> 308dd28f21e91803703c0b8dfcfc0a34cddc7275
    }

}
