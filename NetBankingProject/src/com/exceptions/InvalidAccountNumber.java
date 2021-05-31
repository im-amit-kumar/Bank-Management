package com.exceptions;

public class InvalidAccountNumber extends Exception
{
	private String msg;

	public InvalidAccountNumber(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidAccountNumber [msg=" + msg + "]";
	};
	

}
