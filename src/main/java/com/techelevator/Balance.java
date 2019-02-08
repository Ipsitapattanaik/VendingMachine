package com.techelevator;

public class Balance {
	
	private int currentBalance = 0;
	
	
	public Balance() {
		this.currentBalance = 0;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}
	
	public int addMoney(int moneyToAdd) {
		currentBalance = moneyToAdd + currentBalance;
		return currentBalance;
	}
	
	public int updatePurchase(int itemCost) {
		currentBalance = currentBalance - itemCost;
		return currentBalance;
	}
	
}
