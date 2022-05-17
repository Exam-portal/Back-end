package com.onlineexam.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.Email;

@Service
public class EmailService {

	@Autowired
	private EmailDaoImpl emailDaoImpl;

	public void sendEmail(String toEmail, String code) throws Exception {
		Email email = new Email();
		email.setMailFrom("debumode.dev@gmail.com");
		email.setMailTo(toEmail);
		email.setMailSubject("Online Exam Portal Activation");
		email.setMailContent("Welcome to Online Exam Portal, please use below code to activate user: "+code);
		emailDaoImpl.sendEmail(email);
	}
	
	
}
