package com.onlineexam.portal.controller;

public class GetUserHistoryException  extends RuntimeException{

	private int userId;
	
	public GetUserHistoryException(int userId) {
		super("User "+userId+" not found");
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Unable to fetch results with userId: "+ userId;
	}
}