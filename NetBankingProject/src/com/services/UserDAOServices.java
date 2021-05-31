package com.services;

import com.beans.UserData;

public interface UserDAOServices 
{
	public int insertUserData(UserData u);
	public UserData getUserDetails(String userID);
	public int updatePass(String userID, String password);

}
