package com.onlineexam.portal.controller;

public class AddResultException extends RuntimeException{

	public AddResultException() {
		super();
	}

	@Override
	public String toString() {
		return "Result is not added, some data is missing";
	}
	
}
