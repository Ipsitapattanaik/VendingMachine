package com.techelevator;

public class CandyProduct extends Product{

	
	
	public CandyProduct (String name, int price, String button, String sound) {
		super(name, price, sound, button);
		
	}
	public String getSound() {
		return "Munch Munch, Yum!";
	}
}
