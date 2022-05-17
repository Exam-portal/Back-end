package com.onlineexam.portal.controller;

public class UpdateQuestionBankException extends RuntimeException {

	public UpdateQuestionBankException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to update question bank";
	}
}
