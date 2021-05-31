package com.client;

import java.util.Scanner;

import com.exceptions.InvalidPassword;
import com.exceptions.InvalidUserID;
import com.exceptions.WrongSecurityQuestionAnswer;
import com.providers.AccServicesClientProvider;
import com.providers.UserServicesProvider;
import com.services.ClientServices;
import com.services.UserServices;

public class UserServicesClient implements ClientServices
{
	//Containing object of User Services
	UserServices u = UserServicesProvider.getUserServicesObject();
	
	//Contining object of Account services client code
	ClientServices a = AccServicesClientProvider.getAccServicesClientObject();	
	
	//Client code for UserServices
	public void clientCode()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Bank");
		outer: while(true)
		{
			System.out.println("1) SignUP \n2) LogIn \n3) Forgot Password \n4) Reset Password \n5) Exit \nEnter Your Choice: ");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter UserID: ");
				String userID = scan.next();
				System.out.println("Enter Password: ");
				String password = scan.next();
				System.out.println("Enter Security Question: ");
				String sQue = scan.next();
				System.out.println("Enter Security Answer: ");
				String sAns = scan.next();
				u.signUp(userID, password, sQue, sAns);
				break;
				
			case 2:
				System.out.println("Enter UserID: ");
				String userID1 = scan.next();
				System.out.println("Enter Password");
				String password1 = scan.next();
				try {
					boolean status = u.signIn(userID1, password1);
					if (status == true)
					{
						System.out.println("Succesfully Logged In");
						a.clientCode();			//in case of successful logIn, client code for Account services begin to execute
					}
					
				} catch (InvalidPassword e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidUserID e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Enter UserID: ");
				String userID2 = scan.next();
				System.out.println("Enter Security Question: ");
				String sQue2 = scan.next();
				System.out.println("Enter Security Answer");
				String sAns2 = scan.next();
				try {
					boolean status = u.forgotPass(userID2, sQue2, sAns2);
					if (status == true)
					{
						System.out.println("Succesfully Logged In");
						a.clientCode();			//in case of successful logIn, client code for Account services begin to execute
					}
				} catch (WrongSecurityQuestionAnswer | InvalidUserID e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Enter UserID: ");
				String userID3 = scan.next();
				System.out.println("Enter Old Password");
				String oldPassword3 = scan.next();
				System.out.println("Enter New Password");
				String newPassword3 = scan.next();
				try {
					u.resetPass(userID3, oldPassword3, newPassword3);
				} catch (InvalidPassword e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidUserID e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				break outer;
			}
		}
	}

}
