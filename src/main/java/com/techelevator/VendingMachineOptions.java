package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner; 

public class VendingMachineOptions {
	
	public Map<String,MasterItem> getMapOfItems() throws FileNotFoundException { 
	
	File vmOptions = new File("/Users/ipsitapattanaik/workspace/java-module-1-capstone-team-1/vendingmachine.csv"); 
		
	Map<String, MasterItem> foodOptions = new LinkedHashMap<String, MasterItem>(); //how we get the names, price, slot number for our food options
		
	try(Scanner fileScanner = new Scanner(vmOptions)) {
	
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine(); 
			String[] temp = line.split("\\|"); 
			
				switch (temp[0].charAt(0)) {   //first char of temp[0]
				case 'A': 
					ChipProduct chips = new ChipProduct(); 
					chips.setName(temp[1]);
					chips.setSlot(temp[0]);
					chips.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], chips);  //Put in map, slotA = chips
					break; 
					
				case 'B': 
					CandyProduct candy = new CandyProduct(); 
					candy.setName(temp[1]);
					candy.setSlot(temp[0]);
					candy.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], candy); 
					break;
					
				case 'C': 
					DrinkProduct drink = new DrinkProduct(); 
					drink.setName(temp[1]);
					drink.setSlot(temp[0]);
					drink.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], drink); 
					break; 
					
				case 'D': 
					GumProduct gum = new GumProduct(); 
					gum.setName(temp[1]);
					gum.setSlot(temp[0]);
					gum.setPrice(Double.parseDouble(temp[2]));
					foodOptions.put(temp[0], gum); 
					break;
					
				default: 
					System.out.println("Invalid source file!");
			}
		}
	}
	return foodOptions;
	}
}
