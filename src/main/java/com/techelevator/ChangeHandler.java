package com.techelevator;

public class ChangeHandler {

	private int returnBalance;
	private int quarter1;
	private int dime1;
	private int nickle1;
	
	public String giveChange(int returnBalance) {
		
		quarter1 = returnBalance / 25;
		returnBalance = returnBalance % 25;
		
		dime1 = returnBalance / 10;
		returnBalance = returnBalance % 10;
		
		nickle1 = returnBalance / 5;
		
		return "Your change is " + quarter1 + " quarters"  + "  " + dime1 + " dimes" + "  " + nickle1 + " nickles";
	}
	
	
	
}
