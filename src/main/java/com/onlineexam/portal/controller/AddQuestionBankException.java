package com.onlineexam.portal.controller;

public class AddQuestionBankException extends RuntimeException {

	public AddQuestionBankException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to add question bank";
	}
}
