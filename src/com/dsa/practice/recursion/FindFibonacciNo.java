package com.dsa.practice.recursion;

public class FindFibonacciNo {
	
	// program to find nth fibonacci number
	
	// The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21
	
	// this program would take longer time to find 50th fibo number because of repeatative calls
	// Here dynamic programming comes into picture, DP says if some computation is already calculated 
	// do not compute it again just store it somewhere

	public static void main(String[] args) {
		int n = 5;
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
