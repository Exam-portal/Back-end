package com.onlineexam.portal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineexam.portal.model.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDAO AdminDAOImpl;

	public void add(Admin admin) {

		AdminDAOImpl.addAdmin(admin);
	}

	public Admin findAdmin(int id) {

		return AdminDAOImpl.findAdmin(id);
	}

	public List<Admin> findAllAdmin() {

		return AdminDAOImpl.findAllAdmin();
	}

	public boolean updateAdmin(Admin admin) {

		return AdminDAOImpl.updateAdmin(admin);
	}

	public boolean deleteAdmin(int id) {

		return AdminDAOImpl.deleteAdmin(id);

	}

	public boolean CreateAdmin(int id) {
		return AdminDAOImpl.createAdmin(id);
	}

	public String login(Admin admin) {

		return AdminDAOImpl.login(admin);
	}

	public void changePassword(Admin admin) {
		AdminDAOImpl.changePassword(admin);
	}
	
public  Admin getByEmail(String email) {
		
		return 	AdminDAOImpl.getByEmail(email);
	}



}
