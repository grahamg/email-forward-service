package com.example.springboot.service;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.grandview.model.EmailConfig;
import com.grandview.util.MessageParser;

@Service
public class EmailService {
	
	 @Value("${email.username}")
	 private String username;

	 @Value("${email.pwd}")
	 private String pwd;

	 @Autowired
	 private EmailConfig emailConfig;
	
   Folder emailFolder;
	 Store store;
	
   @postConstruct
   void setup() {
        String server = emailConfig.getHost();
        Session emailSession = Session.getDefaultInstance(emailConfig);
        Store store = null;
     
        try {
            store = emailSession.getStore("pop3s");
            store.connect(server, emailConfig.getUsername(), emailConfig.getPassword());
            emailFolder = store.getFolder("INBOX");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
   }
  
   @Scheduled(fixedRate = 5000)
   synchronized void read() throws MessagingException, IOException {
          emailFolder.open(Folder.READ_ONLY);
          Message[] messages = emailFolder.getMessages();
          for (int i = 0; i < messages.length; i++) {
              Message message = messages[i];
              System.out.println(MessageParser.getMessageBody(message));
          }
          emailFolder.close();
   }
	 
	public void sendEmail(){
	    System.out.println("reading value from propertes file using @value annotation");
	    System.out.println("username ="+ username);
	    System.out.println("pwd ="+ pwd);
	}
	
}
