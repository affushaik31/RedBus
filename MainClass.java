package com.info;

import java.util.Scanner;

class InvalidCredentialsException extends Exception{
       public InvalidCredentialsException(String msg) {
    	   super(msg);
       }
}
class RedBus{
	private String userName,pwd,source,destination,date;
	int noOfPersons;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public void login(String userName,String pwd,Scanner sc) throws InvalidCredentialsException{
		if(userName.equals("shaikaffu31")&&pwd.equals("affu143")) {
			System.out.println("Your login is Successfully completed");
			System.out.println("Enter your source:");
			setSource(sc.nextLine());
			System.out.println("Enter your destination:");
			setDestination(sc.nextLine());
			System.out.println("Enter your Journey date:");
			setDate(sc.nextLine());
			System.out.println("Enter the no. of persons");
			setNoOfPersons(sc.nextInt());
			bookTicket(this);
			displayDetails(this);
		}
		else {
			throw new InvalidCredentialsException("Invalid Uid/pwd...try again");
		}
	}
	public void bookTicket(RedBus rb) {
	     System.out.println("Thank you for booking your ticket");
	    
	}
	public void displayDetails(RedBus rb) {
		System.out.println("source:"+getSource());
		System.out.println("Destination:"+getDestination());
		System.out.println("Journey date:"+getDate());
		System.out.println("No. of persons:"+getNoOfPersons());
	}
}

public class MainClass {
	/**
	 * @param args
	 * @throws InvalidCredentialsException
	 */
	public static void main(String[] args) throws InvalidCredentialsException{
		Scanner sc=new Scanner(System.in);
		RedBus rb=new RedBus();
		while(true) {
			System.out.println("Enter username:");
			rb.setUserName(sc.nextLine());
			System.out.println("Enter password:");
			rb.setPwd(sc.nextLine());
			try {
				rb.login(rb.getUserName(), rb.getPwd(), sc);
				break;
			}
			catch(InvalidCredentialsException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
