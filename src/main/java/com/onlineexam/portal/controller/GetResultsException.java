package com.onlineexam.portal.controller;

public class GetResultsException extends RuntimeException{

	private int userId;
	
	public GetResultsException(int userId) {
		super("User "+userId+" not found");
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Unable to fetch results with userId: "+ userId;
	}
}
