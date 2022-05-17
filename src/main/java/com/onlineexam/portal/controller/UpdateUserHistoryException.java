package com.onlineexam.portal.controller;

public class UpdateUserHistoryException extends RuntimeException{

	public UpdateUserHistoryException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to update user history";
	}
}
