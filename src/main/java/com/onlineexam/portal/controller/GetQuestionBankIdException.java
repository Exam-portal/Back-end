package com.onlineexam.portal.controller;

public class GetQuestionBankIdException extends RuntimeException {


	public GetQuestionBankIdException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to get question bank with id";
	}
}
