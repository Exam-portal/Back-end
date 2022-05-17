package com.onlineexam.portal.controller;



public class FindUserException extends RuntimeException {

	public FindUserException() {
		super();
	}
	
	@Override
	public String toString() {
		return "Unable to find user";
	}
	
}
