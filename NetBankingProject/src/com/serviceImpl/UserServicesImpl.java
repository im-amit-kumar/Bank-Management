package com.serviceImpl;

import com.beans.UserData;
import com.exceptions.InvalidPassword;
import com.exceptions.InvalidUserID;
import com.exceptions.WrongSecurityQuestionAnswer;
import com.providers.UserDAOProvider;
import com.services.UserDAOServices;
import com.services.UserServices;

public class UserServicesImpl implements UserServices
{
	//containing UserDAOservices object through provider class 
	UserDAOServices dao = UserDAOProvider.getUerDAOObject();
	
	//logic for signUP
	public void signUp(String userID, String password, String sQue, String sAns)
	{
		UserData u = new UserData(userID, password, sQue, sAns);
		int count = dao.insertUserData(u);
		if (count>0)
		{
			System.out.println("UserID Created");
		}
	}
	
	//logic for signIn
	public boolean signIn(String userID,String password) throws InvalidPassword, InvalidUserID
	{
		boolean status = false;
		UserData u = dao.getUserDetails(userID);
		if (u != null)
		{
			if (password.equals(u.getPassword()))
			{
				status = true;
			}
			else
			{
				throw new InvalidPassword("Wrong Password Entered");
			}
		}
		else
		{
			throw new InvalidUserID("Invalid User ID");
		}
		return status;
	}
	
	//logic for resetting password
	public void resetPass(String userID, String oldPassword, String newPassword) throws InvalidPassword, InvalidUserID
	{
		boolean status = signIn(userID, oldPassword);
		if (status == true)
		{
			dao.updatePass(userID, newPassword);
			System.out.println("Password Reset Succesful");
		}
	}
	
	//logic for forgetPassword
	public boolean forgotPass(String userID, String sQue, String sAns) throws WrongSecurityQuestionAnswer, InvalidUserID
	{
		boolean status = false;
		UserData u = dao.getUserDetails(userID);
		if (u != null)
		{
			if (sQue.equals(u.getsQue()) && sAns.equals(u.getsAns()))
			{
				status = true;
			}
			else
			{
				throw new WrongSecurityQuestionAnswer("Security Question or Answer Wrong");
			}
		}
		else
		{
			throw new InvalidUserID("Invalid User ID");
		}
		return status;
	}


}
