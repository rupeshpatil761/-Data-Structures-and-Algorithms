package com.dsa.practice.recursion;

public class StepsToZeroNum {
	
	// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

	public static void main(String[] args) {
		int n = 12;
		int ans = numberOfSteps(n);
		System.out.println("Ans: "+ans);
	}

	private static int numberOfSteps(int n) {
		return helper(n,0);
	}

	private static int helper(int n, int steps) {
		if(n==0) {
			return steps;
		}
		if(n%2==0) {
			// even number - divide n by 2 and steps++
			return helper(n/2, ++steps);
		} else {
			// odd number - n -1 and steps++
			return helper(n-1, ++steps);
		}
	}
}
