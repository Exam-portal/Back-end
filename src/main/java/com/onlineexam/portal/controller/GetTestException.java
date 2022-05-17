package com.onlineexam.portal.controller;

public class GetTestException extends RuntimeException{
	public GetTestException() {
		super();
	}

	@Override
	public String toString() {
		return "Test is not found";
	}
}
