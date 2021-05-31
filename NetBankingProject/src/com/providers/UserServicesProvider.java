package com.providers;

import java.io.FileInputStream;
import java.util.Properties;

import com.services.UserServices;

//provider class for UserServices Implementation Object 
public class UserServicesProvider
{
	public static UserServices getUserServicesObject()
	{
		UserServices u = null;
		
		try {
			FileInputStream fis =new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String UserServiceClass = p.getProperty("UserServiceClass");
			u = (UserServices) Class.forName(UserServiceClass).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
