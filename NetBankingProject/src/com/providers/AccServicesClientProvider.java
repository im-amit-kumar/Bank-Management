package com.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.services.ClientServices;

//provider class for AccountServicesClient code object
public class AccServicesClientProvider
{
	public static ClientServices getAccServicesClientObject()
	{
		ClientServices ser = null;
		
		try {
			FileInputStream fis = new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String AccServiceClientClass = p.getProperty("AccServiceClientClass");
			ser = (ClientServices) Class.forName(AccServiceClientClass).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ser;
	}

}
