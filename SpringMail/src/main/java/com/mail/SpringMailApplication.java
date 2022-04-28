package com.mail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mail.service.SpringMailSender;

@SpringBootApplication
public class SpringMailApplication {

	@Autowired
	private SpringMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendTriggerMail() throws MessagingException {

		// for simple message
		//mailSender.sendSimpleMail("dhiraj7219@gmail.com", "This is subject", "This is Body ");
		
		// for mesaage with attachment
		mailSender.sendMailAttachment("dhiraj7219@gmail.com", "This is subject", "This is body",
				"C:\\Users\\DHIRAJ\\Pictures\\Camera Roll\\pic.png");
	}

}
