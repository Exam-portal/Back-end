package com.onlineexam.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class QuestionControllerException {

	@ExceptionHandler(FindAllQuestionExcpetion.class)
	public ResponseEntity<?> findAllQuestionExcpetion(FindAllQuestionExcpetion e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddQuestionException.class)
	public ResponseEntity<?> addQuestionException(AddQuestionException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UpdateQuestionException.class)
	public ResponseEntity<?> updateQuestionException(UpdateQuestionException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DeleteQuestionException.class)
	public ResponseEntity<?> deleteQuestionException(DeleteQuestionException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GetQuestionIdException.class)
	public ResponseEntity<?> getQuestionIdException(GetQuestionIdException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
}
