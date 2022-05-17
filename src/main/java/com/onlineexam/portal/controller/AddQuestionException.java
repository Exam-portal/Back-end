package com.onlineexam.portal.controller;

public class AddQuestionException extends RuntimeException{

	public AddQuestionException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to add question";
	}
}
