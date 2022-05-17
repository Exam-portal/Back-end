package com.onlineexam.portal.controller;

public class DeleteQuestionException extends RuntimeException{

	public DeleteQuestionException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to delete question";
	}
}
