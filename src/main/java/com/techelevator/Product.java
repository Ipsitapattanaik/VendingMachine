package com.techelevator;

public abstract class Product {
 
	//we may need to make an instance variable get sound
	
	
	private String name;
	private int price;
	private String button;
	private String sound;
	protected int counter = 5; 
	
	public Product(String name, int price, String button, String sound) {
		this.name = name;
		this.price = price;
		this.button = button;
		this.sound = sound;	
	}

	public abstract String getSound();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}

	public String getCounter(int counter) {
		while(counter > 0) {
		String count	= Integer.toString(counter);
			return count;
		}return "Sold out";
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
	
	
}
