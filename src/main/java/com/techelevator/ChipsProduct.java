package com.techelevator;

public class ChipsProduct extends Product{


	
	public ChipsProduct (String name, int price, String button, String sound) {
		super(name, price, button, sound );
		
	}
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}
}
