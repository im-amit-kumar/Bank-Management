package com.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.services.ClientServices;

//provider class for UserServicesClient code object
public class UserServicesClientProvider
{
	public static ClientServices getUserServicesClientObject()
	{
		ClientServices ser = null;
		try {
			FileInputStream fis = new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String UserServicesClientClass = p.getProperty("UserServicesClientClass");
			ser = (ClientServices) Class.forName(UserServicesClientClass).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ser;
	}

}
