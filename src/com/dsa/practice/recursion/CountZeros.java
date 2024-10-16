package com.dsa.practice.recursion;

public class CountZeros {

	public static void main(String[] args) {
		int n = 12030502;
		int ans = count(n);
		System.out.println("No of zeros: "+ans);
	}

	private static int count(int n) {
		
		return helper(n, 0);// 2nd argument is count
		
	}

	private static int helper(int n, int c) {
		
		if(n==0)
			return c;
		
		int rem = n % 10;
		
		if(rem == 0) {
			return helper(n/10, c+1);
		}
		
		return helper(n/10, c);
	}
}
