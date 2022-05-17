package com.onlineexam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineexam.portal.dao.AdminService;
import com.onlineexam.portal.model.Admin;

@RestController
public class AdminController {

	@Autowired
	AdminService service;

	@CrossOrigin("*")
	@PostMapping("/addAdmin")

	public ResponseEntity<?> addAdmin(@RequestBody(required = false) Admin admin) throws AddAdminException {
		if (admin == null) {
			throw new AddAdminException();
		}
		service.add(admin);
		return ResponseEntity.status(HttpStatus.OK).body("admin added successfully");

	}

	@CrossOrigin("*")
	@GetMapping("/findadmin/{id}")
	public Admin getAdminByEmail(@PathVariable String id) throws GetAdminException {
//		if (Integer.parseInt(id) <= 0) {
//			throw new GetAdminException();
//		}
		return service.getByEmail(id);
	}


	@GetMapping("/adminLogin")
	public ResponseEntity<?> login(@RequestBody Admin admin) throws LoginException {
		if (admin == null) {
			throw new LoginException();
		}
		return ResponseEntity.ok(service.login(admin));
	}

	@PostMapping("/passwordChange")
	public ResponseEntity<?> changePassword(@RequestBody Admin admin) throws ChangePasswordException {
		if (admin == null) {
			throw new ChangePasswordException();
		}
		service.changePassword(admin);
		return ResponseEntity.ok("admin password changed successfully");
	}

	@GetMapping("/profile/{userId}")
	public ResponseEntity<?> getUserProfile(@PathVariable(value = "userId") int userId) throws ViewProfieException {
		if (userId <= 0) {
			throw new ViewProfieException();
		}
		return ResponseEntity.ok(service.findAdmin(userId));
	}

}
