package com.onlineexam.portal.controller;

public class GetResultException extends RuntimeException{

	private int id;
	
	public GetResultException(int id) {
		super("Result "+id+" not found");
		this.id = id;
	}

	@Override
	public String toString() {
		return "Unable to fetch result with id: "+ id;
	}
}
