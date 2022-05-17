package com.onlineexam.portal.controller;

public class FindAllQuestionExcpetion extends RuntimeException{

	public FindAllQuestionExcpetion() {
		super();
	}

	@Override
	public String toString() {
		return "No questions found with given data";
	}
}
