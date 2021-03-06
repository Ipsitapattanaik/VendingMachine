package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.change.MakeChange;

public class VendingMachineCLI {

	private void welcome() {
		System.out.println("+----------------------------------+");
		System.out.println("|          Vendo-Matic 500         |");
		System.out.println("|                by                |");
		System.out.println("|           Ipsita and Dan         |");
		System.out.println("|              help from           |");
		System.out.println("|            Tom, Andrew,          |");
		System.out.println("|     StackOverflow, W3Schools,    |");
		System.out.println("|             Quora and            |");
		System.out.println("|           Java Tutorial          |");
		System.out.println("+----------------------------------+");
	}
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String PURCHASE_MENU_OPTION_SALES_REPORT = "Sales Report";
	
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
			PURCHASE_MENU_OPTION_FINISH_TRANSACTION , PURCHASE_MENU_OPTION_SALES_REPORT};
	
	
	private static final String FEED_OPTION_1 = "add $1";
	private static final String FEED_OPTION_2 = "add $2";
	private static final String FEED_OPTION_3 = "add $5";
	private static final String FEED_OPTION_4 = "add $10";
	private static final String[] FEED_MENU_OPTIONS = { FEED_OPTION_1, FEED_OPTION_2, FEED_OPTION_3, FEED_OPTION_4};
	

	
	private Menu menu;
	static Scanner in = new Scanner (System.in);
	//constructor
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a"); 
	Date date = new Date(); 
	public void run() throws IOException {
		
		//objects we need access to throughout
		Map<String, MasterItem> foodOptions = new LinkedHashMap<String, MasterItem>(); //creating empty map to fill with items
		VendingMachineOptions VMoption = new VendingMachineOptions();
		
		for (String s : VMoption.getMapOfItems().keySet())  { //populating our local Map with items from the VendingMachineOptions class
			foodOptions.put(s, VMoption.getMapOfItems().get(s));
		}
		MakeChange makeChange = new MakeChange();
		
		
		CustomerMoney customerBalance = new CustomerMoney();
		welcome();
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items, start here and make this work first
				//System.out.println("Slot " + "Item             " + "Price " + "Quantity");
				
				
				for (String y : foodOptions.keySet()) {
					
					System.out.print(foodOptions.get(y).getSlot() + " ");     //get slot number populated
					System.out.print(foodOptions.get(y).getName().substring(0, 18) + " ");    //get product name populated
					System.out.print("$" + String.format("%.2f", foodOptions.get(y).getPrice()) + " ");    //get price populated
					
					
					//Check if product is in stock or sold out and print message
					if (foodOptions.get(y).getQuantity() != 0) {
					System.out.print(foodOptions.get(y).getQuantity());
					} else {
						System.out.print("SOLD OUT");
					}
					
					System.out.println("");
				}
				
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) { //audit is in the format date, time, what happened, amount of money, amount of money again
				List<String> sounds = new ArrayList<String>();
				List<String> audit = new ArrayList<String>(); 
				
				while(true) {
				System.out.println("Currrent Money Provided: " + "$" + String.format("%.2f", customerBalance.getCurrentMoney())); //add customer money total here 
				
				String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						String choice3 = (String)menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
						double add = 0; 
							if (choice3.equals(FEED_OPTION_1)) {
								customerBalance.addToCurrent(1.0);
								add = 1.00; 
							} else if (choice3.equals(FEED_OPTION_2)) {
								customerBalance.addToCurrent(2.0);
								add = 2.00;
							} else if (choice3.equals(FEED_OPTION_3)) {
								customerBalance.addToCurrent(5.0);
								add = 5.00;
							} else { //option 4
								customerBalance.addToCurrent(10.0);
								add = 10.00;
							}	
						audit.add(dateFormat.format(date) + " FEED MONEY:  " + "$" + String.format("%.2f", add) + "      " + "$" + String.format("%.2f" , customerBalance.getCurrentMoney()));
						
					} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) { 
																					
						System.out.println("Please enter the product slot to purchase");
						String userChoice = in.nextLine();
						double priorBalance = 0; 
						//double localPrice = 0; 
						
						if (foodOptions.get(userChoice) == null || foodOptions.get(userChoice).getPrice() > customerBalance.getCurrentMoney()) {
							System.out.println("Invalid choice.");
							System.out.println("");
						} else {
							
							System.out.println(foodOptions.get(userChoice).purchaseAndMessage(foodOptions.get(userChoice).getName()));
							if (foodOptions.get(userChoice).getQuantity() >= 0) {
								customerBalance.subractFromCurrent(foodOptions.get(userChoice).getPrice());
								sounds.add(foodOptions.get(userChoice).consume());
								priorBalance = (customerBalance.getCurrentMoney() + foodOptions.get(userChoice).getPrice()); 
								audit.add(dateFormat.format(date) + " " + foodOptions.get(userChoice).getName().substring(0, 9)  + " " + foodOptions.get(userChoice).getSlot() + " $" + String.format("%.2f" , priorBalance) + "      " + "$" + String.format("%.2f", customerBalance.getCurrentMoney()));
							}
						}
						
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						
						audit.add(dateFormat.format(date) + " " + "GIVE CHANGE: " + "$" + String.format("%.2f" , customerBalance.getCurrentMoney()) + "      " + "$" + String.format("%.2f", 0.0));
						System.out.println("Your change is: " + makeChange.makeChange(customerBalance.getCurrentMoney()));
						customerBalance.subractFromCurrent(customerBalance.getCurrentMoney());
						
						for (String sound : sounds) {
							System.out.println(sound);
						}
						
						File log = new File("/Users/ipsitapattanaik/workspace/java-module-1-capstone-team-1/log.txt"); 
						try (FileWriter writer = new FileWriter(log.getAbsoluteFile(), true)) { 
							for (String x : audit) {
								writer.write(x + "\n");
							} 
							writer.flush();
						}
						//break;
					}else if (choice2.equals(PURCHASE_MENU_OPTION_SALES_REPORT)) {
						
						double totalSales = 0;
						
						for (String z : foodOptions.keySet()) {
							
							//System.out.print(foodOptions.get(z).getSlot() + " ");     //get slot number populated
							System.out.print(foodOptions.get(z).getName().substring(0, 18) + "|");    //get product name populated  .substring(0, 18)
							//System.out.print("$" + String.format("%.2f", foodOptions.get(z).getPrice()) + " ");    //get price populated
							System.out.println(foodOptions.get(z).getQuantity());
							
							totalSales = totalSales + ((5 - (foodOptions.get(z).getQuantity())) * foodOptions.get(z).getPrice());
							//Check if product is in stock or sold out and print message
							//if (foodOptions.get(z).getQuantity() != 0) {
							//System.out.print(foodOptions.get(z).getQuantity());
							//} else {
							//	System.out.print("SOLD OUT");
							//System.out.println("**Total Sales**  " + totalSales);
							}
							System.out.println("\n **Total Sales**  " + totalSales + "\n\n");
							//System.out.println("");
						}
					}
				}
			}
		}
	//}
	
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}