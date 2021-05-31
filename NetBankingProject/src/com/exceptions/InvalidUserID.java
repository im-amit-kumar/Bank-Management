package com.exceptions;

public class InvalidUserID extends Exception
{
	private String msg;

	public InvalidUserID(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidUserID [msg=" + msg + "]";
	}
	
	

}
