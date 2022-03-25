package com.atm.api;

public class MoneyTracker {
	
	private int $20value = 20;   // 20 dollar bill value 
	
	private int $50value = 50;   // 50 dollar bill value 
	
	private int notesCounter20; // notes counter

	private int notesCounter50;
	private int atmCurrentCash;
	

	public MoneyTracker(int notesCounter20, int notesCounter50) {
		
		this.notesCounter20 = notesCounter20;
		this.notesCounter50 = notesCounter50;
		this.atmCurrentCash = (this.notesCounter20 * this.$20value) + (this.notesCounter50 * this.$50value ) ;
	}

	@Override
	public String toString() {
		return "the amount of 20 dollars bills are " + notesCounter20 + ",the amount of 50 dollars bills are " + notesCounter50 + "]";
		
	}
	
	
	

	public int getNotesCounter20() {
		return notesCounter20;
	}

	public void setNotesCounter20(int notesCounter20) {
		this.notesCounter20 = notesCounter20;
	}

	public int getNotesCounter50() {
		return notesCounter50;
	}

	public void setNotesCounter50(int notesCounter50) {
		this.notesCounter50 = notesCounter50;
	}
	public int getAtmCurrentCash() {
		return atmCurrentCash;
	}

	public void setAtmCurrentCash(int atmCurrentCash) {
		this.atmCurrentCash = atmCurrentCash;
	}
	
	

	
	
	public int cashCounter() {
	     this.atmCurrentCash = (this.notesCounter20 * this.$20value) + (this.notesCounter50 * this.$50value ) ;
	        
	        return atmCurrentCash;
		
	}
	
	public void withdrawl(int dispencingAmount) {
		
		this.atmCurrentCash = this.atmCurrentCash - dispencingAmount;
	}

	
	
	
	

   
}
