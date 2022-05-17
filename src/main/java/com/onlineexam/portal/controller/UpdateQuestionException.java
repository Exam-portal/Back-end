package com.onlineexam.portal.controller;

public class UpdateQuestionException extends RuntimeException{


	public UpdateQuestionException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to update question";
	}
}
