package com.onlineexam.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdminControllerException {

	@ExceptionHandler(ChangePasswordException.class)
	public ResponseEntity<?> changePasswordException(ChangePasswordException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddAdminException.class)
	public ResponseEntity<?> addAdminException(AddAdminException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<?> loginException(LoginException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ViewProfieException.class)
	public ResponseEntity<?> viewProfieException(ViewProfieException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GetAdminException.class)
	public ResponseEntity<?> getAdminException(GetAdminException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}

}
