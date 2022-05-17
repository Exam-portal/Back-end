package com.onlineexam.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResultControllerException {

	@ExceptionHandler(GetResultsException.class)
	public ResponseEntity<?> getResultException(GetResultsException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddResultException.class)
	public ResponseEntity<?> addResultException(AddResultException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateResultException.class)
	public ResponseEntity<?> updateResultException(UpdateResultException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeleteResultException.class)
	public ResponseEntity<?> deleteResultException(DeleteResultException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GetResultException.class)
	public ResponseEntity<?> getResultException(GetResultException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
	}
}
