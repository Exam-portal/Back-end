package com.onlineexam.portal.controller;

public class AddTestException extends RuntimeException{
	public AddTestException() {
		super();
	}

	@Override
	public String toString() {
		return "Test is not added, some data is missing";
	}
}
