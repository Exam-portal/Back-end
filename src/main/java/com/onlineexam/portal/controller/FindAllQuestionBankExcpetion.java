package com.onlineexam.portal.controller;

public class FindAllQuestionBankExcpetion extends RuntimeException {

	public FindAllQuestionBankExcpetion() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to find questions with test id";
	}
}
