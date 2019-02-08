package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StockInventory {
	
	public Map<String, Product> inventoryMap = new HashMap<String, Product>();
	
	
	
	 
public void startUpStock () {
	
	
	try (Scanner fileScanner = new Scanner("/Users/danielherold/workspace/java-module-1-capstone-team-1/vendingmachine.csv")) {

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
		
			if(!line.isEmpty()) {
				
				String[]loadList = line.split(" ");
				
				String newLocation = loadList[0];
				String newName = loadList[1];
				int newPrice = Integer.parseInt(loadList[2]);
				String newSound = loadList[3];
				
				
					switch(loadList[3]) {
					case "Chip": 
						ChipsProduct chip = new ChipsProduct(newName, newPrice, newLocation, newSound);
						inventoryMap.put(newLocation, chip);
						
					case "Drink":
						DrinkProduct drink = new DrinkProduct(newName, newPrice, newLocation, newSound);
						inventoryMap.put(newLocation, drink);
						
					case "Gum":
						GumProduct gum = new GumProduct(newName, newPrice, newLocation, newSound);
						inventoryMap.put(newLocation, gum);
						
					case "Candy":
						CandyProduct candy = new CandyProduct(newName, newPrice, newLocation, newSound);
						inventoryMap.put(newLocation, candy);
					}
				
//				inventoryList.put(loadList[0], loadList[1]);
//				priceList.put(loadList[1], (Integer.parseInt(loadList[2])));
//				productType.put(loadList[1], loadList[3]);
			}
			}
			}
		
	catch (Exception e) {
		System.out.println("could not find file");
	}

	}

}
	
		
	
	
	

