package com.onlineexam.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.onlineexam.portal.controller.AdminController;
import com.onlineexam.portal.controller.ChangePasswordException;
import com.onlineexam.portal.controller.LoginException;
import com.onlineexam.portal.controller.ViewProfieException;
import com.onlineexam.portal.dao.AdminService;
import com.onlineexam.portal.model.Admin;

@SpringBootTest
class AdminTests {

	@Autowired
	AdminController adminController;

	@Autowired
	AdminService adminService;

	@Test
	void testLoginFailure() {
		try {
			adminController.login(null);
			assert false;
		} catch (LoginException e) {
			assertEquals(e.toString(), "invalid login details");
			assert true;
		}
	}

	@Test
	void changePasswordSuccess() {
		Admin admin = new Admin();
		admin.setId(2);
		admin.setName("Dharma");
		admin.setEmail("XYZ@gmail.com");
		admin.setAddress("XYZ street");
		admin.setPassword("2222");
		adminService.add(admin);
		List<Admin> admins = adminService.findAllAdmin();
		assertEquals(ResponseEntity.ok("admin password changed successfully"),
				adminController.changePassword(admins.get(admins.size() - 1)));
	}

	@Test
	void changePasswordFailure() {
		try {
			adminController.changePassword(null);
			assert false;
		} catch (ChangePasswordException e) {
			assertEquals(e.toString(), "Unable to change password");
			assert true;
		}
	}

	@Test
	void getUserProfileSuccess() {
		Admin admin = new Admin();
		admin.setId(2);
		admin.setName("Dharma");
		admin.setEmail("XYZ@gmail.com");
		admin.setAddress("XYZ street");
		admin.setPassword("2222");
		// adminService.add(admin);
		List<Admin> admins = adminService.findAllAdmin();
		assertNotNull(adminController.getUserProfile(admins.get(admins.size() - 1).getId()));
	}

	@Test
	void getUserProfileFailure() {
		try {
			adminController.getUserProfile(0);
			assert false;
		} catch (ViewProfieException e) {
			assertEquals(e.toString(), "profile data not found");
			assert true;
		}
	}

}