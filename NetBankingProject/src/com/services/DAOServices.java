package com.services;

import com.beans.Account;

public interface DAOServices 
{
	public int getNewAccountNumber();
	public int insertAccountData(Account acc);
	public Account getAccountDetails(int accNo);
	public int updateAccountBalance(int accNo, float accBal);
}