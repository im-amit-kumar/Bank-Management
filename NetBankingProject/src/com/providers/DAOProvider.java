package com.providers;

import java.io.FileInputStream;
import java.util.Properties;

import com.services.DAOServices;

//provider class for Account DAO Object
public class DAOProvider
{
	public static DAOServices getDAOOjbect()
	{
		DAOServices dao = null;
		try
		{
			FileInputStream fis = new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String DAOClass = p.getProperty("DAOClass");
			dao = (DAOServices) Class.forName(DAOClass).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dao;
	}

}
