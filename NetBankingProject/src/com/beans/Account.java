package com.beans;

public class Account 
{
	//Data Abstraction
	private int accNo;
	private String accType;
	private float accBal;

	//Constructor
	public Account(int accNo, String accType, float accBal) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.accBal = accBal;
	}

	//Getter setter Methods
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public float getAccBal() {
		return accBal;
	}

	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}

	//toString Method
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", accBal="
				+ accBal + "]";
	}

	
}
