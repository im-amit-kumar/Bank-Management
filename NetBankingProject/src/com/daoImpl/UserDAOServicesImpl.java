package com.daoImpl;

import java.sql.*;

import com.beans.UserData;
import com.providers.DAOConnectionProvider;
import com.services.UserDAOServices;

public class UserDAOServicesImpl implements UserDAOServices
{
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public UserDAOServicesImpl()
	{
		//getting connection through provider class
		con = DAOConnectionProvider.getDBConnection();
	}
	
	//this method inserts data of UserData Object into the Database 
	public int insertUserData(UserData u)
	{
		int updateCount = 0;
		try {
			stmt = con.prepareStatement("insert into UserData values(?,?,?,?)");
			stmt.setString(1, u.getUserID());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getsQue());
			stmt.setString(4, u.getsAns());
			updateCount = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateCount;
	}
	
	//this method returns UserData object for the given userID
	public UserData getUserDetails(String userID)
	{
		UserData u = null;
		try {
			stmt = con.prepareStatement("select * from UserData where userID = ?");
			stmt.setString(1, userID);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				String userID1 = rs.getString(1);
				String password = rs.getString(2);
				String sQue = rs.getString(3);
				String sAns = rs.getString(4);
				u = new UserData(userID1, password, sQue, sAns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	//this object updates the password in the database for the given userID
	public int updatePass(String userID, String password)
	{
		int updateCount = 0;
		try {
			stmt = con.prepareStatement("update UserData set password = ? where userID = ?");
			stmt.setString(1, password);
			stmt.setString(2, userID);
			updateCount = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateCount;
	}

}
