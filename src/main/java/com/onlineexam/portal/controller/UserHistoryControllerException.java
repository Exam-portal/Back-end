package com.onlineexam.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserHistoryControllerException {

	@ExceptionHandler(GetUserHistoryException.class)
	public ResponseEntity<?> getUserHistoryException(GetUserHistoryException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddUserHistoryException.class)
	public ResponseEntity<?> addUserHistoryException(AddUserHistoryException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateUserHistoryException.class)
	public ResponseEntity<?> updateUserHistoryException(UpdateUserHistoryException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeleteUserHistoryException.class)
	public ResponseEntity<?> deleteUserHistoryException(DeleteUserHistoryException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
}
