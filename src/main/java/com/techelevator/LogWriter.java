package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogWriter {

	public void writer(String typeOfTransaction, int amount, int balance) {
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		File logFile = new File("logFile.txt");
		String outputLine = "";
		
		
		try(PrintWriter writer = new PrintWriter(logFile)){
			outputLine = today + "  " + now + "  " ;
			
		}
		catch(Exception e){
			
		}
	}
}

