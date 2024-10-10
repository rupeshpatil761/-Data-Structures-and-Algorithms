package com.dsa.practice.recursion;

public class FindFibonacciNo {

	public static void main(String[] args) {
		int n = 4;
		int ans = fibo(n);
		System.out.println("Fibo of "+n +" is : "+ans);
	}
	
	private static int fibo(int n) {
		if(n < 2) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
}
