package com.onlineexam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.EmailService;
import com.onlineexam.portal.dao.UserTableService;
import com.onlineexam.portal.model.UserTable;

@RestController
public class UserTableController {

	@Autowired
	UserTableService userService;

	@Autowired
	EmailService emailService;

	@CrossOrigin("*")
	@PostMapping("/adduser")
	public ResponseEntity<?> adduser(@RequestBody UserTable user) {
		userService.add(user);
		return ResponseEntity.status(HttpStatus.OK).body("user added successfully");

	}

	@CrossOrigin("*")
	@GetMapping("/finduser/{id}")
	public ResponseEntity<?> getUserTable(@PathVariable String id){
		UserTable userTable = new UserTable();
		try {
			userTable = userService.getByEmail(id);
			return ResponseEntity.status(HttpStatus.OK).body(userTable);
		} catch (FindUserException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}

	@CrossOrigin("*")
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {
		List<UserTable> users= userService.findAll();
		if(users.size()<=0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no users are found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PostMapping("/registration")
	public String addUser(@RequestBody UserTable user) {
		userService.add(user);
		return "user added successfully";
	}

	@PostMapping("/changePassword")
	public String changePassword(@RequestBody UserTable user) {
		userService.changePassword(user);
		return "password changed successfully";
	}

	@GetMapping("/viewPassword")
	public String viewPassword(@RequestBody UserTable user) {
		return userService.viewPassword(user);
	}

	@PostMapping("/activateUser")
	public String verifyCode(@RequestBody UserTable user) {
		return userService.verifyCode(user);
	}

//	@GetMapping("/profile")
//	public UserTable profile(@RequestBody UserTable user) {
//		return userService.profile(user);
//	}

}
