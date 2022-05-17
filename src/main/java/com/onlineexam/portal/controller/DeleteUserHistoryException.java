package com.onlineexam.portal.controller;

public class DeleteUserHistoryException extends RuntimeException{
	public DeleteUserHistoryException() {
		super();
	}

	@Override
	public String toString() {
		return "Unable to delete user history";
	}
}
