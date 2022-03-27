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

					NoteCombination FinalCombination =  getCombination(Combination ,  m1);
					 if (FinalCombination.getNote$20() == 0 &&  FinalCombination.getNote$50() == 0){
						 System.out.println("Combination not available,pleasse try another amount");
					 }
					 else {
						 m1.withdrawl(withdrawalAmount);
						 notesDiff50 = m1.getNotesCounter50() - FinalCombination.getNote$50() ;
						 notesDiff20 =  m1.getNotesCounter20() - FinalCombination.getNote$20() ;
						 m1.setNotesCounter50(notesDiff50);
						 m1.setNotesCounter20(notesDiff20);
						 System.out.println("Here is your money,thank you");
						 System.out.println("You withdrawed " + withdrawalAmount + "dollars");

					 }



				}
				else{
					System.out.println("We are sorry we dont have this amount of cash at the time please try another amount ");
					System.out.println(" or come back later ") ;
					break;
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

		for (int i = withdrawalAmount / m1.get$50value(); i >= 0; i--) {

			j = (withdrawalAmount - m1.get$50value() * i) / m1.get$20value();
			jmod = (withdrawalAmount - m1.get$50value() * i) % m1.get$20value();
			if (jmod == 0){
				NoteCombination noteCombination = new NoteCombination();
				noteCombination.setNote$20(j);
				noteCombination.setNote$50(i);
				noteCombinationList.add(noteCombination);
				System.out.println("[20$| "+j +","+" " + i + "|50$]");
				nopair = false;
			}
		}

		if(nopair){
			System.out.println("no pair");
		}

		return noteCombinationList;


	}
	public static NoteCombination getCombination(List<NoteCombination> noteCombinationList , AutomaticTellerMachine m1)  {


		for (NoteCombination noteCombination : noteCombinationList){
			if(checkValidCombination(noteCombination ,  m1)){
				return noteCombination;
			}
		}
                return new NoteCombination();
	}
	public static boolean checkValidCombination(NoteCombination noteCombination,AutomaticTellerMachine m1 ) {

		if (noteCombination.getNote$20() <= m1.getNotesCounter20() && noteCombination.getNote$50() <= m1.getNotesCounter50()) {
			return true;
		}else{
			return false;
		}
	}
	 }




