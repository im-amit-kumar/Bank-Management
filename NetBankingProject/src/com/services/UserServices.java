package com.services;

import com.exceptions.InvalidPassword;
import com.exceptions.InvalidUserID;
import com.exceptions.WrongSecurityQuestionAnswer;

public interface UserServices 
{
	public void signUp(String userID, String password, String sQue, String sAns);
	public boolean signIn(String userID,String password) throws InvalidPassword, InvalidUserID;
	public void resetPass(String userID, String oldPassword, String newPassword) throws InvalidPassword, InvalidUserID;
	public boolean forgotPass(String userID, String sQue, String sAns) throws WrongSecurityQuestionAnswer, InvalidUserID;
}
