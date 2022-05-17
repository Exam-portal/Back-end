package com.onlineexam.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class QuestionBankControllerException {

	@ExceptionHandler(FindAllQuestionBankExcpetion.class)
	public ResponseEntity<?> findAllQuestionBankExcpetion(FindAllQuestionBankExcpetion e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddQuestionBankException.class)
	public ResponseEntity<?> addQuestionBankException(AddQuestionBankException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UpdateQuestionBankException.class)
	public ResponseEntity<?> updateQuestionBankException(UpdateQuestionBankException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DeleteQuestionBankException.class)
	public ResponseEntity<?> deleteQuestionBankException(DeleteQuestionBankException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GetQuestionBankIdException.class)
	public ResponseEntity<?> getQuestionBankIdException(GetQuestionBankIdException e, WebRequest req) {
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
}
