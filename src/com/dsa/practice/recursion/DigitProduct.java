package com.dsa.practice.recursion;

public class DigitProduct {
	
	public static void main(String[] args) {
		int ans = product(1234);
		System.out.println("Ans: "+ans);
	}

	private static int product(int num) {
		
		// if N%10 == number itself -- return N
		if(num%10 == num) { // if one digit is remaining return that number itself
			return num;
		}
		
		return product(num/10) * (num%10);
	}
}
