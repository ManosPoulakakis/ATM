package com.atm.api;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboardScanner=new Scanner(System.in);
		
		
		
		System.out.println("deposit 20 bank notes and 50 bank notes");
	    int	twenty = keyboardScanner.nextInt();
        int fifty = keyboardScanner.nextInt();
		
		MoneyTracker m1 = new MoneyTracker(twenty,fifty);
		
		
		int choice ;
		int dispencingAmount;
		int notesDiff50;
		int notesDiff20;
		

	
		
		System.out.println("1. Withdrawl");
		System.out.println("2. Money Counter");
		System.out.println("3. Exit");
		
		while(true) {
		choice = keyboardScanner.nextInt();
		if (choice == 1) {
			System.out.println("Please insert the amount of money you wish to dispence"); 
			     dispencingAmount = keyboardScanner.nextInt();
		/*	try {
				dispencingAmount = keyboardScanner.nextInt();
			    } catch (Exception e) {
			      System.out.println("Something went wrong,try giving a number .");
			      
			    } */
			     
			while(true) {
			if (dispencingAmount <= m1.getAtmCurrentCash()) {
				
				
				 if ((dispencingAmount/50) > m1.getNotesCounter50() ){
		             
			           int valueOf50 = m1.getNotesCounter50() * 50 ;
			           int difference = dispencingAmount - valueOf50 ;
			           int valueOf20 = m1.getNotesCounter20() * 20 ;   
			           int difference20 = dispencingAmount - valueOf20;
			           
			  
			              if ((difference % 20) == 0 && (difference / 20) <= m1.getNotesCounter20()  ){
				              notesDiff50 = 0  ;
				              notesDiff20 =  (m1.getNotesCounter20() - (difference / 20));
		                      m1.setNotesCounter50(notesDiff50) ;
		                      m1.setNotesCounter20(notesDiff20);
		                      
			               }
			              else if((difference % 20 == 10 && (difference / 20) <= m1.getNotesCounter20()  )) {
			            	  System.out.println("ATM needs refill, try amount that ends in 20 ,40 60,80 dollar bills");
			            	  break;
			              }
			            
			              
			              
		                  else {
		                     System.out.println("out of cash");
		                      break;
		                     }

		             }
				     
			
				 else if (dispencingAmount % 50 == 0) { 
                    	   
                    	     
 
			        	notesDiff50 = m1.getNotesCounter50() -(dispencingAmount/ 50);
				   
				         m1.setNotesCounter50(notesDiff50);
			        	   
			        }
			        else if(dispencingAmount % 50 == 30 && dispencingAmount != 30) {
			        	notesDiff50 = m1.getNotesCounter50() - ((dispencingAmount/ 50) - 1);
			        	notesDiff20 = m1.getNotesCounter20() - (((dispencingAmount % 50)+50)/20);
			        	  m1.setNotesCounter20(notesDiff20);
			        	  m1.setNotesCounter50(notesDiff50);
			        }
			        
			        else if (dispencingAmount % 50 == 40 && dispencingAmount!=40) {
			        	notesDiff50= m1.getNotesCounter50() - (dispencingAmount/ 50);
			        	notesDiff20 = m1.getNotesCounter20() - ((dispencingAmount % 50)/20);
			        	 m1.setNotesCounter20(notesDiff20);
			        	 m1.setNotesCounter50(notesDiff50);
			          }
			        
			        else if (dispencingAmount % 20 == 0 && dispencingAmount < 100 ) {
				         notesDiff20 = m1.getNotesCounter20() -(dispencingAmount/ 20);
				           m1.setNotesCounter20(notesDiff20);
			          }
			        
			      
			        
			        else if (dispencingAmount % 50 == 20) {
			        	notesDiff50= m1.getNotesCounter50() - (dispencingAmount/ 50);
			        	notesDiff20 = m1.getNotesCounter20() - ((dispencingAmount % 50)/20);
			        	 m1.setNotesCounter20(notesDiff20);
			        	 m1.setNotesCounter50(notesDiff50);
			          }
			       
			        
			        	 else {
				         System.out.println("The number is incorrect you need to try again");
				          break;
			           }
			  m1.withdrawl(dispencingAmount);
			   
			System.out.println("Here is your money,thank you");
			System.out.println("You withdrawed " + dispencingAmount + "dollars");
			   break;
			}
			
			else {
				System.out.println("We are sorry we dont have this amount of cash at the time please try another amount ");
				System.out.println(" or come back later ") ;
				break;
			    }
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
	 }