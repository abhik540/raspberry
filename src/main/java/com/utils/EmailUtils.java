package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
@Slf4j
public class EmailUtils {

    @Value("${mail.smtp.host}")
    private String smtpHost;

    @Value("${mail.smtp.port}")
    private Integer smtpPort;

    @Value("${mail.smtp.auth}")
    private Boolean smtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private Boolean smtpStartTlsEnable;

    private static String USERNAME;
    private static String PASSWORD;

    @Value("${mail.smtp.usernaame}")
    public void setUsername(String username) {
        EmailUtils.USERNAME = username;
    }

    @Value("${mail.smtp.password}")
    public void setPassword(String password) {
        EmailUtils.PASSWORD = password;
    }

    public static Session getSession() {
        final Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        return Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
    }

    public static Message buildMessage(Session session, String subject, String messageText) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("sujan.maharjan.2015@gmail.com")
        );
        message.setSubject(subject);
        message.setText(messageText);
        return message;
    }
}
