package com.dsa.practice.recursion;

public class DigitSum {

	public static void main(String[] args) {
		int ans = sum(43234);
		System.out.println("Ans: "+ans);
	}

	private static int sum(int num) {
		
		if(num == 0) {
			return 0;
		}
		
		return sum(num/10) + (num%10);
	}
}
