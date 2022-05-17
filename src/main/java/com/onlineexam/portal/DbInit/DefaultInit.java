package com.onlineexam.portal.DbInit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.portal.dao.AdminDAOImpl;
import com.onlineexam.portal.dao.UserTableDaoImpl;
import com.onlineexam.portal.model.Admin;

@Component
public class DefaultInit {

	@Autowired
	private AdminDAOImpl adminDAOImpl;
	
	@Autowired
	private UserTableDaoImpl userTableDaoImpl; 
	
	@PostConstruct
    private void initAdminUser() {
        Admin admin = new Admin();
        admin.setAddress("test");
        admin.setEmail("admin@gmail.com");
        admin.setName("Admin");
        admin.setPassword("1234");
        adminDAOImpl.saveOrUpdateAdmin(admin);
    }
	
//	@PostConstruct
//    private void initTestUser() {
//        UserTable user = new UserTable();
//		user.setPassword("1234");
//		user.setName("Online Exam User");
//		user.setAddress("Eaxam");
//		user.setRole("");
//		user.setEmail("vasanthakaju5259@gmail.com");
//		userTableDaoImpl.saveOrUpdateUser(user);
//    }
}
