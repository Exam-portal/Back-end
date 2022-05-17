package com.onlineexam.portal.controller;

public class AddUserHistoryException extends RuntimeException{

	public AddUserHistoryException() {
		super();
	}

	@Override
	public String toString() {
		return "User History is not added, some data is missing";
	}
	
}
