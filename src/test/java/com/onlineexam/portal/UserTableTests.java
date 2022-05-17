package com.onlineexam.portal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineexam.portal.dao.UserTableService;
import com.onlineexam.portal.model.UserTable;

@SpringBootTest
public class UserTableTests {

	@Autowired
	UserTableService userService;

	@Test
	void testLoginSuccess() {
		UserTable user = new UserTable();
		user.setId(20);
		user.setPassword("1234");
		String status=userService.login(user);
		assertEquals("Sent email for activation", status);
	}

	@Test
	void testLoginFailure() {
		UserTable user = new UserTable();
		user.setId(20);
		user.setPassword("12345");
		assertEquals("Fail", userService.login(user));
	}

	@Test
	void testChangePassword() {
		UserTable user = new UserTable();
		user.setId(20);
		user.setPassword("1234");
		userService.changePassword(user);
		assertEquals("1234", userService.viewPassword(user));
		user.setPassword("1234");
		userService.changePassword(user);
	}

	@Test
	void testViewPassword() {
		UserTable user = new UserTable();
		user.setId(20);
		assertEquals("1234", userService.viewPassword(user));
	}

}
