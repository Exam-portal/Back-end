package com.onlineexam.portal.controller;

public class DeleteTestException extends RuntimeException{

	public DeleteTestException() {
		super();
	}

	@Override
	public String toString() {
		return "Test is not deleted, some data is missing";
	}
}
