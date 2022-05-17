package com.onlineexam.portal.controller;

public class AddAdminException extends RuntimeException{

	public AddAdminException() {
		super("Unable to add admin");
	}

	public  String toString() {
		return "Unable to add admin";
	}

	
}
