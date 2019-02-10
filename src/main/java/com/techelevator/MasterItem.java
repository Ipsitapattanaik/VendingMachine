package com.techelevator;

public interface MasterItem {
	
	
	public String getName(); 
	
	public void setName(String name); 
	
	public String getSlot(); 
	
	public void setSlot(String slot); 
	
	public double getPrice(); 
	
	public void setPrice(double price); 
	
	public int getQuantity(); 
	
	public String consume(); //for the noises at the end
	
	public void purchase(); //when we want to change quantity
	
	public String purchaseAndMessage(String getName);	
	
	
}
