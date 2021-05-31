package com.exceptions;

public class WrongSecurityQuestionAnswer extends Exception
{
	private String msg;

	public WrongSecurityQuestionAnswer(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "WrongSecurityQuestionAnswer [msg=" + msg + "]";
	}
	
	
}
