package com.dsa.practice.recursion;

public class ReverseNumber {

	public static void main(String[] args) {
		int n = 1234567; // 7654321 | false
		//int n = 12321; // 12321 | true
		int ans = reverse(n); 
		System.out.println("Ans: "+ans +" | isPalindrom: "+isPalindrom(n, ans));
	}

	private static int reversedNumber = 0;
	
	private static int reverse(int n) {
		if(n == 0) {
			return reversedNumber;
		}
		int digit = n%10;
		
		reversedNumber = reversedNumber * 10 + digit;
		
		return reverse(n/10);
	}
	
	private static boolean isPalindrom(int n, int ans) {
		
		return (n == ans); 
		
	}
}
