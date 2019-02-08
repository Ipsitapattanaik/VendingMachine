package com.techelevator;

public class GumProduct extends Product{


	
	public GumProduct (String name, int price, String button, String sound ) {
		super(name, price, button, sound);
		
	}
	public String getSound() {
		return "Chew Chew, Yum!";
	}
	
}
