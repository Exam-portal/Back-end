package com.onlineexam.portal.controller;

public class ViewProfieException extends RuntimeException {

	public ViewProfieException() {
		super("profile data not found");
	}

	public String toString() {
		return "profile data not found";
	}
}
