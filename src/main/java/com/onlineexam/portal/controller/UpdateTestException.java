package com.onlineexam.portal.controller;

public class UpdateTestException extends RuntimeException{

	public UpdateTestException() {
		super();
	}

	@Override
	public String toString() {
		return "Test is not updated, some data is missing";
	}
}
