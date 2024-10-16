package com.dsa.practice.amex;

public class CurrencyCounter {
	
	private static int[] notes = {2000,500,200,100,50,20,10,5,2,1};
	//private static int[] notes = {1,2,5};
	
	public static void main(String[] args) {
		
		//solution(2500);
		//solution(1750);
		//solution(1235);
		solution(11);
	}
	
	private static void solution(int amount) {
		System.out.println("input amount: "+amount);
		int[] noteCounter = new int[notes.length];
		
		for (int i=0; i<notes.length; i++) {
			if(amount >= notes[i]) {
				noteCounter[i] = amount / notes[i]; // how many notes would require
				amount = amount % notes[i]; // remaining amount
			}
		}
		
		for (int i=0; i<notes.length; i++) {
			if(noteCounter[i] != 0) {
				System.out.println("Note of Rs : "+notes[i] +" = "+noteCounter[i]);
			}
		}
		System.out.println("-----------------------------");
	}
}
