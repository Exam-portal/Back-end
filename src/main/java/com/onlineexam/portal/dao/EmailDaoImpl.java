package com.onlineexam.portal.dao;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.Email;

@Service
public class EmailDaoImpl implements EmailDao {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(Email email) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(email.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(email.getMailFrom()));
			mimeMessageHelper.setTo(email.getMailTo());
			mimeMessageHelper.setText(email.getMailContent());
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
