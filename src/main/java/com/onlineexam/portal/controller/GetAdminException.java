package com.onlineexam.portal.controller;

public class GetAdminException extends RuntimeException{

	public GetAdminException() {
		super("Unable to find admin");
	}

	public String toString() {
		return "Unable to find admin";
	}
}
