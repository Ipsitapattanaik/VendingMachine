package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunningVendingMachine {

	public static void main(String[] args) {
	
			
			System.out.println("Hello World");
			
			StockReader stockreader = new StockReader();
			Map<String, List<Product>> mapOfProduct = new HashMap<String, List<Product>>();
			mapOfProduct = stockreader.fileImporter();
			
			
			VendingMachine VM = new VendingMachine(mapOfProduct);
			
			VM.displayInventory();
			
			System.out.println("Bye bye");

			
		}
		
	

}
