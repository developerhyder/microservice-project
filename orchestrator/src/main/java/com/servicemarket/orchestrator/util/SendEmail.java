package com.servicemarket.orchestrator.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static String send(String email, String msg,int serviceId,String name, double amnt, String serviceName){
		
		 // Recipient's email ID needs to be mentioned.
       String to = email;

       // Sender's email ID needs to be mentioned
       String from = "developerhyder@gmail.com";

       // Assuming you are sending email from through gmails smtp
       String host = "smtp.gmail.com";

       // Get system properties
       Properties properties = System.getProperties();

       // Setup mail server
       properties.put("mail.smtp.host", host);
       properties.put("mail.smtp.port", "465");
       properties.put("mail.smtp.ssl.enable", "true");
       properties.put("mail.smtp.auth", "true");

       // Get the Session object.// and pass username and password
       Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

           protected PasswordAuthentication getPasswordAuthentication() {

               return new PasswordAuthentication("sender@gmail.com", "**********");

           }

       });

       // Used to debug SMTP issues
       session.setDebug(true);

       try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

           // Set Subject: header field
           message.setSubject("Reciept from service market");

           // Now set the actual message
           String body = "Hi "+name+", \n\nThank you for buying our service. Our customer executive will get in touch with you very soon."
           			+"\n\nDetails:\n\nService id: "+serviceId+"\n\nService Name: "+serviceName+"\n\nAmount Paid: "+amnt+"\n\ntransaction id: "+msg+"\n\nhave a good day\n\n";
           message.setText(body);

           // Send message
           Transport.send(message);
           return "otp was sent to "+email+" check you mail";
       } catch (MessagingException mex) {
           mex.printStackTrace();
           return "something went wrong";
       }
		
	}
}
