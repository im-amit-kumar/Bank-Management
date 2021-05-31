package com.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.services.AccountServices;

//provider class for account services object
public class AccountServicesProvider
{
	public static AccountServices getAccountServicesObject()
	{
		AccountServices a = null;
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(".//resources//info.properties");
			Properties p = new Properties();
			p.load(fis);
			String AccountServicesClass = p.getProperty("AccountServicesClass");
			a = (AccountServices) Class.forName(AccountServicesClass).newInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
