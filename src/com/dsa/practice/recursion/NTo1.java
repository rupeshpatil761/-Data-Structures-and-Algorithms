package com.dsa.practice.recursion;

public class NTo1 {

	public static void main(String[] args) {
		// print N to 1
		printNTo1(5);
		
		System.out.println("------------");
		
		print1ToN(5);
	}

	private static void printNTo1(int n) {
		System.out.println(n);
		if(n!=1) {
			printNTo1(n-1);
		}
	}
	
	
	private static void print1ToN(int n) {
		if(n!=1) {
			print1ToN(n-1);
		}
		System.out.println(n);
	}
	

}
