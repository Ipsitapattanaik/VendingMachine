package com.techelevator;

public  interface Balance1 {

public int currentBalance = 0;
	
	
//	public Balance() {
//		this.currentBalance = currentBalance;
//	}

	static public int getCurrentBalance() {
		return currentBalance;
	}
	
	static public int addMoney(int moneyToAdd) {
		//currentBalance = moneyToAdd + currentBalance;
		return currentBalance;
	}
	
	static public int updatePurchase(int itemCost) {
		//currentBalance = currentBalance - itemCost;
		return currentBalance;
	}
	
}
