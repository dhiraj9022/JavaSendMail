package com.mail.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SpringMailSender {

	private JavaMailSender mailSender;

	public SpringMailSender(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public void sendSimpleMail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dhiraj2067590@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);

		System.out.println("Mail sent successfully !!");
	}

	public void sendMailAttachment(String toEmail, String subject, String body, String attachment)
			throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setFrom("dhiraj206750@gmail.com");
		messageHelper.setTo(toEmail);
		messageHelper.setSubject("This is subject ");
		messageHelper.setText("This is body");
		
		FileSystemResource systemResource = new FileSystemResource(new File(attachment));
		messageHelper.addAttachment(systemResource.getFilename(), systemResource);
		mailSender.send(mimeMessage);

		System.out.println("Mail send with attachment");
	}
}
