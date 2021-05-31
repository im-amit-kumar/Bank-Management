package com.beans;

public class UserData
{
	//Data Abstraction
	private String userID;
	private String password;
	private String sQue;
	private String sAns;
	
	//Constructor
	public UserData(String userID, String password, String sQue, String sAns) {
		super();
		this.userID = userID;
		this.password = password;
		this.sQue = sQue;
		this.sAns = sAns;
	}
	
	//Getter Setter Methods
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getsQue() {
		return sQue;
	}
	public void setsQue(String sQue) {
		this.sQue = sQue;
	}
	public String getsAns() {
		return sAns;
	}
	public void setsAns(String sAns) {
		this.sAns = sAns;
	}
}
