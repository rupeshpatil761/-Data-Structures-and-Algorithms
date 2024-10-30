package com.dsa.practice.amex.practice;

import java.util.*;

public class PlusOneToArray {

	public static void main(String[] args) {
		// Input: [1,2,3]
		// Output: [1,2,4]

		int[] nums = { 2, 9, 9 };

		nums = solution(nums);
		System.out.println("Result: " + Arrays.toString(nums));
	}

	private static int[] solution(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < 9) {
				nums[i]++;
				return nums;
			} else {
				nums[i] = 0;
			}
		}
		int[] newArray = new int[nums.length + 1];
		newArray[0] = 1;
		return newArray;
	}

}
