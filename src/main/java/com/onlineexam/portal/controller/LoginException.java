package com.onlineexam.portal.controller;

	
	public class LoginException extends RuntimeException {
		
		public LoginException() {
			super("login will not be  successfull");
		}

		public  String toString() {
			return "invalid login details";
		}
	}

