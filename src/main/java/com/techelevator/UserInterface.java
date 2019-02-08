package com.techelevator;

import java.util.Scanner;

public class UserInterface {

	boolean exit = false;
	private Balance balance;
	
	
	public static void main(String[] args) {
		Balance myBalance = new Balance();
		
		UserInterface user = new UserInterface( myBalance);
		
		
		int welcomeSelection = user.runWelcomeMenu();
		
		
		int feedMoneyFromUser = user.feedMoneyMenu();
		
		//getInventoryList(selection);
		
	}
	
	public UserInterface (Balance balance) {
		this.balance = balance;
	}
	
	
	public int runWelcomeMenu() {
		welcomeMenu();
		displayMenu();
		int choice = getIntInput();
		if (choice == 1) {
			//getInventoryList
		}else if(choice == 2) {
			runPurchaseMenu();
		}
		
		return choice;
		
	}
	
	private void welcomeMenu() {
		System.out.println("+-------------------------------------+");
		System.out.println("|           Vendo-Matic 500           |");
		System.out.println("|                 by                  |");
		System.out.println("|            Ipsita and Dan           |");
		System.out.println("|              help from              |");
		System.out.println("|           Tom, Andrew, and          |");
		System.out.println("|                Google               |");
		System.out.println("+-------------------------------------+");
		
	}
	private void displayMenu() {
		System.out.println("\n Please Select one of the following \n");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase and Pay");
		
	
}
	
	private int getIntInput() {
		Scanner keyBoard = new Scanner(System.in);
		
		int choice = -1;
		while(choice < 0 || choice > 2 ) {
			try {
				choice = Integer.parseInt(keyBoard.nextLine());
				
			}
			catch (NumberFormatException e) {
				System.out.println("Selection must be a valid menu number");
			}
		}return choice;
	}
	
	private void purchaseMenu() {
		System.out.println("Please select an option from the menu below \n");
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3 Finish Transaction");
		System.out.println("Current balance: " + balance.getCurrentBalance());		
	}
	private int feedMoneyMenu() {
		System.out.println("Please insert money in whole dollar amount of $(1), $(2), $(5), $(10)");
		Scanner keyBoard = new Scanner(System.in);
			
			//int choice;
		int choice = 0;
			while(choice == 1 || choice == 2 || choice == 5 || choice == 10) {
				try {
					choice = Integer.parseInt(keyBoard.nextLine());
					//System.out.println("get choice" + choice);
				}
				catch (NumberFormatException e) {
					System.out.println("Selection must be a valid menu number");
				}
			}return choice;
	}
	
	
	
	private void runPurchaseMenu() {
		int selection = -1;
		
		while(!(selection == 3)) {
			purchaseMenu();
			selection = getPurchaseMenuSelection();
		switch (selection) {
		case 1:
			int money = feedMoneyMenu();
			balance.addMoney(money);
			
		case 2: 
			//SelectProduct();
		case 3:
			 
		}
		}
	}
	
	private int getPurchaseMenuSelection() {
		Scanner keyBoard = new Scanner(System.in);
		
		int choice = -1;
		while(choice < 0 || choice > 3 ) {
			try {
				choice = Integer.parseInt(keyBoard.nextLine());
				
			}
			catch (NumberFormatException e) {
				System.out.println("Selection must be a valid menu number");
			}
		}return choice;
	}
	
}
