package com.daoImpl;

import java.sql.*;

import com.beans.Account;
import com.providers.DAOConnectionProvider;
import com.services.DAOServices;

public class DAOServiceImpl implements DAOServices
{
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public DAOServiceImpl()
	{
		//getting connection through provider class
		con = DAOConnectionProvider.getDBConnection();
	}
	
	//this Method returns the account number to be given to new account
	//object by incrementing the highest Account Number in the database by 1
	public int getNewAccountNumber()
	{
		int newAccNo = 0;
		try
		{
			stmt = con.prepareStatement("select max(accno) from Account");
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				newAccNo = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return newAccNo+1;
	}
	
	//this method inserts the data of account object into Database
	public int insertAccountData(Account acc) 
	{
		int updateCount=0;
		try 
		{
			stmt=con.prepareStatement("insert into Account values(?,?,?)");
			stmt.setInt(1, acc.getAccNo());
			stmt.setString(2, acc.getAccType());
			stmt.setFloat(3, acc.getAccBal());
			updateCount=stmt.executeUpdate();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return updateCount;
	}

	//this method returns account object from the database based on given accNO
	public Account getAccountDetails(int accNo) 
	{
		Account acc=null;
		try
		{
			stmt=con.prepareStatement("select * from Account where accNo=?");
			stmt.setInt(1, accNo);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				int accNo1=rs.getInt(1);
				String accType=rs.getString(2);
				float accBal=rs.getFloat(3);
				acc=new Account(accNo1, accType, accBal);
			}
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return acc;
	}
	
	//this method updates the accBal of the given accNo in the database
	public int updateAccountBalance(int accNo, float accBal)
	{
		int updateCount = 0;
		try
		{
			stmt=con.prepareStatement("update account set accBal = ? where accno = ?");
			stmt.setFloat(1, accBal);
			stmt.setInt(2, accNo);
			updateCount = stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updateCount;
	}
	
}
