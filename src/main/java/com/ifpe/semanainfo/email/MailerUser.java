package com.ifpe.semanainfo.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.ifpe.semanainfo.model.UserModel;



@Component
public class MailerUser {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine thymeleaf;
	
	@Async
	public void enviar(UserModel usuario){
	   
		Context context =  new Context();
	    context.setVariable("ag", usuario);	
	   
	   MimeMessage minMessage = mailSender.createMimeMessage();
	   
	   try {
		   String email = thymeleaf.process("email/emailUser", context);
		MimeMessageHelper helper = new MimeMessageHelper(minMessage, true, "UTF-8");
		helper.setFrom("ttvents@gmail.com");
		helper.setTo(usuario.getEmail());
		helper.setSubject("TT's EVENTS - Obrigado pela preferência.");
		helper.setText(email, true);
		
	
		
		 mailSender.send(minMessage);
	} catch (MessagingException e) {
		 e.printStackTrace();
	}  
		
	  
	}
}
