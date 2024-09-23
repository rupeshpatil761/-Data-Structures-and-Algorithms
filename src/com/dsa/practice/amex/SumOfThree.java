package com.dsa.practice.amex;

import java.util.Arrays;

public class SumOfThree {

	// https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/description/
	public static void main(String[] args) {
		/***
		 *  Input: num = 33
			Output: [10,11,12]
			Explanation: 33 can be expressed as 10 + 11 + 12 = 33.
			10, 11, 12 are 3 consecutive integers, so we return [10, 11, 12].
		 */
		
		int num = 33;
		
		int[] result = solution(num);
		
		System.out.println("3 consequtive numbers whose sum is "+num+ " are: " + Arrays.toString(solution(num)));
		
	}

	// Time complexity: O(1)
	private static int[] solution(int num) {
		if(num%3!=0) {
			return new int[]{};
		} 
		
		num  = num / 3;
		
		return new int[] {num-1, num, num+1};
	}

}
