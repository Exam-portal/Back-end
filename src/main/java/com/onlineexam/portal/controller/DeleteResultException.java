package com.onlineexam.portal.controller;

public class DeleteResultException extends RuntimeException{
	public DeleteResultException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to delete result";
	}
}
