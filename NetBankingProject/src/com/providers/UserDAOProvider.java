package com.providers;

import java.io.FileInputStream;
import java.util.Properties;

import com.services.UserDAOServices;

//provider class for UserDAOServicesImpl Object
public class UserDAOProvider
{
	public static UserDAOServices getUerDAOObject()
	{
		UserDAOServices dao = null;
		try
		{
			FileInputStream fis = new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String UserDAOClass = p.getProperty("UserDAOClass");
			dao = (UserDAOServices) Class.forName(UserDAOClass).newInstance();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dao;
	}

}
