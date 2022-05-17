package com.onlineexam.portal.dao;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.model.Email;

@Repository
public interface EmailDao {

	public void sendEmail(Email email);
}
