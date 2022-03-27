package com.atm.api;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboardScanner=new Scanner(System.in);
		
		
		
		System.out.println("Insert the amount of 20$ bank notes");
	    int	twenty = keyboardScanner.nextInt();
		System.out.println("Insert the amount of 50$ bank notes");
        int fifty = keyboardScanner.nextInt();
		
		AutomaticTellerMachine m1 = new AutomaticTellerMachine(twenty,fifty);
		
		
		int choice ;
		int withdrawalAmount;
		int notesDiff50;
		int notesDiff20;
		

	
		
		System.out.println("1. Withdrawl");
		System.out.println("2. Money Counter");
		System.out.println("3. Exit");
		
		while(true) {
			choice = keyboardScanner.nextInt();
			if (choice == 1) {
				System.out.println("Please insert the amount of money you wish to Withdraw");
				withdrawalAmount = keyboardScanner.nextInt();
		/*	try {
				withdrawalAmount = keyboardScanner.nextInt();
			    } catch (Exception e) {
			      System.out.println("Something went wrong,try giving a number .");

			    } */

				if (withdrawalAmount <= m1.getAtmCurrentCash()) {

					List<NoteCombination> Combination = getAllCombinations(withdrawalAmount, m1);
					System.out.println();


				}
			}
		
		else if (choice == 2) {
			System.out.println (m1.toString());
			System.out.println("the Current amount of money on the atm are " + m1.cashCounter() + " dollars");
			}
           
		
		else if (choice == 3) {
			
			System.out.println("GoodBye");
			break;
			}
		
		else  {
			
			System.out.println("Error 404 Choice Not found");
		  }
		}





	   }
	public static List<NoteCombination> getAllCombinations(int withdrawalAmount,AutomaticTellerMachine m1)  {

		int j = 0;
		int jmod = 0;
		List<NoteCombination> noteCombinationList = new ArrayList<NoteCombination>();
		boolean nopair = true;

		for (int i = 0; i <= withdrawalAmount / m1.get$50value(); i++) {

			j = (withdrawalAmount - m1.get$50value() * i) / m1.get$20value();
			jmod = (withdrawalAmount - m1.get$50value() * i) % m1.get$20value();
			if (jmod == 0){
				NoteCombination noteCombination = new NoteCombination();
				noteCombination.setNote$20(j);
				noteCombination.setNote$50(i);
				noteCombinationList.add(noteCombination);
				System.out.println("[ "+j +","+" " + i + "]");
				nopair = false;
			}
		}

		if(nopair){
			System.out.println("no pair");
		}

		return noteCombinationList;
	}
	 }



