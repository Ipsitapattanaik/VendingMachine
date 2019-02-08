package com.techelevator;

public class DrinkProduct extends Product{


	
	public DrinkProduct (String name, int price, String button, String sound) {
		super(name, price, button, sound);
		
	}
	public String getSound() {
		return "Glug Glug, Yum";
	}
}
