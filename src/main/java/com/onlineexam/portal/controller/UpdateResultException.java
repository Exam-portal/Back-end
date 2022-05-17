package com.onlineexam.portal.controller;

public class UpdateResultException extends RuntimeException{
	
	public UpdateResultException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to update result";
	}
}
