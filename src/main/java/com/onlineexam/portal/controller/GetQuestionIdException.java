package com.onlineexam.portal.controller;

public class GetQuestionIdException extends RuntimeException {

	public GetQuestionIdException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to find question";
	}
	
}
