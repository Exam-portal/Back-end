package com.onlineexam.portal.dao;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.controller.FindUserException;
import com.onlineexam.portal.model.UserTable;

@Service
public class UserTableService {

	@Autowired
	UserTableDao userDaoImpl;
	
	@Autowired
	EmailService emailService;



	public void add(UserTable user) {
		userDaoImpl.add(user);
	}

	public void changePassword(UserTable user) {
		userDaoImpl.changePassword(user);
	}
	
	public UserTable getByEmail(String email) throws FindUserException{
		List<UserTable> users=userDaoImpl.getByEmail(email);
		if(users.size()<=0) {
			throw new FindUserException();
		}
		return users.get(0);
	}
	
	public String viewPassword(UserTable user) {
		return userDaoImpl.viewPassword(user);
	}
	
     public String verifyCode(UserTable user) {
		return userDaoImpl.verifyCode(user);
	}
     
    public UserTable findUserTable(int id)
    {
    	return userDaoImpl.findUser(id);
    }
    
	 public List<UserTable> findAll() {
	
		return userDaoImpl.findAllUser();
	}
	
	
	
	
	public String login(UserTable user) {
		String status = userDaoImpl.login(user);
		if(status.equals("Success")) {
			UserTable userDetails = userDaoImpl.findUser(user.getId());
			if(!userDetails.getStatus().equals("A")) {
				try {
					String code=gen();
//					emailService.sendEmail(userDetails.getEmail(),code);
					userDetails.setCode(code);
					userDaoImpl.updateCode(userDetails);
					return "Sent email for activation";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
//
//	
//	}
	public String gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    int actCode = 10000 + r.nextInt(20000);
	    return Integer.toString(actCode);
	}

	
}
