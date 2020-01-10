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

import com.ifpe.semanainfo.model.Manager;





@Component
public class MailerManager {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine thymeleaf;
	
	@Async
	public void enviar(Manager manager){
	   
		Context context =  new Context();
	    context.setVariable("ag", manager);	
	   
	   MimeMessage minMessage = mailSender.createMimeMessage();
	   
	   try {
		String email = thymeleaf.process("email/emailManager", context);
		MimeMessageHelper helper = new MimeMessageHelper(minMessage, true, "UTF-8");
		helper.setFrom("besoftware9@gmail.com");
		helper.setTo(manager.getEmail());
		helper.setSubject("besoftware- Cadastrice agora.");
		helper.setText(email, true);
		
	
		
		 mailSender.send(minMessage);
	} catch (MessagingException e) {
		 e.printStackTrace();
	}  
		
	  
	}
}
