package com.exceptions;

public class InvalidPassword extends Exception
{
	private String msg;

	public InvalidPassword(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidPassword [msg=" + msg + "]";
	}
	

}
