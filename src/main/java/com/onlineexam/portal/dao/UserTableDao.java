package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onlineexam.portal.controller.FindUserException;
import com.onlineexam.portal.model.UserTable;

@Repository
public interface UserTableDao {

	public String login(UserTable user);
	public void add(UserTable user);
	public void updateCode(UserTable user);
	public void changePassword(UserTable user);
	public String viewPassword(UserTable user);
	public UserTable findUser(int id);
	public List<UserTable> findAllUser();
	public String verifyCode(UserTable user);
	public List<UserTable> getByEmail (String email);
	void saveOrUpdateUser(UserTable user);
}

