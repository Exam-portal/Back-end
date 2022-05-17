package com.onlineexam.portal.controller;

public class ChangePasswordException extends RuntimeException{
	
	public ChangePasswordException() {
		super("password cannot be changed successfully");
	}
	public String toString() {
		return "Unable to change password";
	}

}
