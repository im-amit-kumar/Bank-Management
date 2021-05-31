package com.client;

import java.util.Scanner;

import com.exceptions.InsufficientBalance;
import com.exceptions.InvalidAccountNumber;
import com.providers.AccountServicesProvider;
import com.services.AccountServices;
import com.services.ClientServices;

//Client code class for account services
public class AccountServicesClient implements ClientServices
{
	//Containing object of Account services
	AccountServices a = AccountServicesProvider.getAccountServicesObject();
	
	//client code for Account Services
	public void clientCode()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Services Offered: \n1) Open New Account \n2) Balance Enquiry \n3) Display Account Details \n4) Deposit Money \n5) Withdraw Money \n6) FundTransfer \n7) LogOut");
		outer: while(true)
		{
			System.out.println("Enter Your Choice");
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Account Type: ");
				String accType = scan.next();
				System.out.println("Enter Opening Account Balance: ");
				float accBal = scan.nextFloat();
				int accNo = a.openAccount(accType, accBal);
				System.out.println("New Account Opened with A/c No: " + accNo);
				break;
		
			case 2:
				System.out.println("Enter Account Number: ");
				int accNo1 = scan.nextInt();
				float accBal1;
				try {
					accBal1 = a.balEnquiry(accNo1);
					System.out.println("Account Balance for A/c: " + accNo1 + " = " + accBal1);
				} catch (InvalidAccountNumber e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Enter Account Number: ");
				int accNo2 = scan.nextInt();
				try {
					a.printAccountDetails(accNo2);
				} catch (InvalidAccountNumber e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Enter Account Number: ");
				int accNo3 = scan.nextInt();
				System.out.println("Enter Amount to be deposited: ");
				float amount3 = scan.nextFloat();
				try {
					float accBal3 = a.deposit(accNo3, amount3);
					System.out.println("Current Balance in A/c:" + accNo3 + " = " + accBal3);
				} catch (InvalidAccountNumber e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Enter Account Number: ");
				int accNo4 = scan.nextInt();
				System.out.println("Enter Amount to be Withdrawn: ");
				float amount4 = scan.nextFloat();
				try {
					float accBal4 = a.withdraw(accNo4, amount4);
					System.out.println("Current Balance in A/c:" + accNo4 + " = " + accBal4);
				} catch (InvalidAccountNumber e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InsufficientBalance e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				System.out.println("Enter Account Number to be transferred from: ");
				int accNo5 = scan.nextInt();
				System.out.println("Enter Account Number to be transferred to: ");
				int accNo6 = scan.nextInt();
				System.out.println("Enter Amount to be transferred: ");
				float amount5 = scan.nextFloat();
				try {
					a.fundTransfer(accNo5, accNo6, amount5);
				} catch (InvalidAccountNumber | InsufficientBalance e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 7:
				System.out.println("Succesfully Logged Out");
				break outer;
			}
		}
	}

}
