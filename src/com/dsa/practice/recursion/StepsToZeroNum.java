package com.dsa.practice.recursion;

public class StepsToZeroNum {
	
	// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

	public static void main(String[] args) {
		int n = 14;
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
	
	/*Example 1:
		Input: num = 14
		Output: 6
		Explanation: 
		Step 1) 14 is even; divide by 2 and obtain 7. 
		Step 2) 7 is odd; subtract 1 and obtain 6.
		Step 3) 6 is even; divide by 2 and obtain 3. 
		Step 4) 3 is odd; subtract 1 and obtain 2. 
		Step 5) 2 is even; divide by 2 and obtain 1. 
		Step 6) 1 is odd; subtract 1 and obtain 0.
	*/
}
