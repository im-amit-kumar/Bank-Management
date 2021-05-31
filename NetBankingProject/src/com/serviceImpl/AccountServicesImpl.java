package com.serviceImpl;

import com.beans.Account;
import com.exceptions.InsufficientBalance;
import com.exceptions.InvalidAccountNumber;
import com.providers.DAOProvider;
import com.services.AccountServices;
import com.services.DAOServices;

public class AccountServicesImpl implements AccountServices
{
	//Containing object of DAOServices
	DAOServices dao = DAOProvider.getDAOOjbect();
	
	//logic for opening new account
	public int openAccount(String accType, float accBal)
	{
		int accNo = dao.getNewAccountNumber();		//returns the account number to be given to new account object
													//by incrementing the highest Account Number in the database by 1
		Account a = new Account(accNo, accType, accBal);
		int count = dao.insertAccountData(a);
		if (count>0)
		{
			System.out.println("Account Created Succesfully");
		}
		return accNo;
	}
	
	//logic for searching account
	public Account searchAcc(int accNo)throws InvalidAccountNumber
	{
		Account acc = dao.getAccountDetails(accNo);
		if (acc != null)
		{
			return acc;
		}
		else
		{
			throw new InvalidAccountNumber("Account Number Doesn't Exist");
		}
	}
	
	//logic for depositing money in given account
	public float deposit(int accNo, float amount) throws InvalidAccountNumber
	{
		Account acc = searchAcc(accNo);
		float currentAccBal = acc.getAccBal();
		float newAccBal = currentAccBal + amount;
		int count = dao.updateAccountBalance(accNo, newAccBal);
		if (count>0)
		{
			System.out.println("Balance Deposited to A/c:" + acc.getAccNo() +" = " + amount);
		}
		return newAccBal;
	}
	
	//logic for withdrawing money from given account
	public float withdraw(int accNo, float amount) throws InvalidAccountNumber, InsufficientBalance
	{
		Account acc = searchAcc(accNo);
		float currentAccBal = acc.getAccBal();
		if (currentAccBal < amount)
		{
			throw new InsufficientBalance("Insufficient Balance in Account");
		}
		float newAccBal = currentAccBal - amount;
		int count = dao.updateAccountBalance(accNo, newAccBal);
		if (count>0)
		{
			System.out.println("Balance Withdrawn from A/c:" + acc.getAccNo() +" = " + amount);
		}
		return newAccBal;
	}
	
	//logic for balance Enquiry
	public float balEnquiry(int accNo) throws InvalidAccountNumber
	{
		Account acc = searchAcc(accNo);
		float accBal = acc.getAccBal();
		return accBal;
	}
	
	//logic for printing account details
	public void printAccountDetails(int accNo) throws InvalidAccountNumber
	{
		Account acc = searchAcc(accNo);
		System.out.println(acc);
	}
	
	//logic for fund transfer
	public void fundTransfer(int accNo1, int accNo2, float amount) throws InvalidAccountNumber, InsufficientBalance
	{
		Account acc1 = searchAcc(accNo1);
		Account acc2 = searchAcc(accNo2);
		if (acc1 != null | acc2 != null)
		{
			withdraw(accNo1, amount);
			deposit(accNo2, amount);
			System.out.println("Fund Transfer Succesful");
		}
	}
}
