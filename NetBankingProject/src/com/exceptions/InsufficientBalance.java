package com.exceptions;

public class InsufficientBalance extends Exception
{
	private String msg;

	public InsufficientBalance(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InsufficientBalance [msg=" + msg + "]";
	}
	
	
}
