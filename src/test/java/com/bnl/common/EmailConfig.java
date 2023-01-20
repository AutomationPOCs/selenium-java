package com.bnl.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailConfig {

	public static void emailSending() throws IOException{
		// TODO Auto-generated method stub
		
		// Recipient's email ID needs to be mentioned.
        String to = "toemail";

        // Sender's email ID needs to be mentioned
        String from = "fromemail";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        
        final String pass = "appPass";

        // Get system properties
        Properties properties = System.getProperties();
//        Properties properties = new Properties();
        
     // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
//      properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.transport.protocol","smtp");
//      properties.put("mail.smtp.socketFactory.port","587");
//      properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        
     // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
            	System.out.println(pass);
                return new PasswordAuthentication("fromemail", pass);

            }

        });
        
     // Used to debug SMTP issues
        session.setDebug(true);
        
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the Subject Line!");
         
            MimeBodyPart mimeBodyPart= new MimeBodyPart();
            mimeBodyPart.setContent("<h2>HI, this email is generated for testing purpose</h2>","text/html");
            
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File(System.getProperty("user.dir")+"/target/cucumber-reports/report.html")); 
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }	

	}

}
