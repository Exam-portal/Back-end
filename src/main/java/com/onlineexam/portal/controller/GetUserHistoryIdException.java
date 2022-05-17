package com.onlineexam.portal.controller;

public class GetUserHistoryIdException extends RuntimeException{

	private int id;
	
	public GetUserHistoryIdException(int id) {
		super("user history "+id+" not found");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Unable to fetch user history with id: "+ id;
	}
}
