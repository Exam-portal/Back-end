package com.onlineexam.portal.controller;

public class DeleteQuestionBankException extends RuntimeException {

	public DeleteQuestionBankException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to delete question bank";
	}
}
