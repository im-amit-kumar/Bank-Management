package com.providers;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

//provider class for database connection
public class DAOConnectionProvider
{
    public static Connection getDBConnection()
    {
    	Connection con=null;
    	try
		{
			FileInputStream fis=new FileInputStream(".//resources//DBconfig.properties");
			Properties p=new Properties();
			p.load(fis);
			
			//extracting info from properties
			
			String driver=p.getProperty("driver");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			
			//create database connection
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
    }
}
