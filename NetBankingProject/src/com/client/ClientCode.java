package com.client;

import com.providers.UserServicesClientProvider;
import com.services.ClientServices;

public class ClientCode
{
	//Main Method - Entry Point of the program
	public static void main(String[] args) 
	{
		//containing UserServicesClientCode Object
		ClientServices ser = UserServicesClientProvider.getUserServicesClientObject();
		
		//executing the client code
		ser.clientCode();
		
	}

}
