package com.services;

import com.beans.Account;
import com.exceptions.InsufficientBalance;
import com.exceptions.InvalidAccountNumber;

public interface AccountServices 
{
	public int openAccount(String accType, float accBal);
	public Account searchAcc(int accNo)throws InvalidAccountNumber;
	public float deposit(int accNo, float amount) throws InvalidAccountNumber;
	public float withdraw(int accNo, float amount) throws InvalidAccountNumber, InsufficientBalance;
	public float balEnquiry(int accNo) throws InvalidAccountNumber;
	public void printAccountDetails(int accNo) throws InvalidAccountNumber;
	public void fundTransfer(int accNo1, int accNo2, float amount) throws InvalidAccountNumber, InsufficientBalance;
}
