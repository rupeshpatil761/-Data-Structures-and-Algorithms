package com.dsa.practice.recursion;

public class Factorial {

	public static void main(String[] args) {
		int ans = fact(5);
		System.out.println("Ans: "+ans);
	}

	private static int fact(int n) {

		if(n == 1) {
			return n;
		}
		
		return n * fact(n-1);
	}
}
