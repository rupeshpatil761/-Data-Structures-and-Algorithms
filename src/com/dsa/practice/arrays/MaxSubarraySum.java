package com.dsa.practice.arrays;

public class MaxSubarraySum {
	
	// https://www.youtube.com/watch?v=Qd_qhRsSays
	
	// Given an integer array nums, find the subarray with the largest sum, and return its sum.
	
	/*
	 * Example 1: Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The
	 * subarray [4,-1,2,1] has the largest sum 6.
	 */
	
	/*
	 * Example 3: Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray
	 * [5,4,-1,7,8] has the largest sum 23
	 */

	public static void main(String[] args) {
		
		//naiveApproach();
		kadaneAlgoApproach();
	}
	
	// O(n2)
	private static void naiveApproach() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSum = 0;
		for(int i=0; i<=nums.length;i++) {
			int sum = 0;
			for(int j=i; j<nums.length;j++) {
				sum += nums[j];
				if(sum > maxSum) {
					maxSum = sum;
				}
			}
			// reset sum because i will move forward and sub arrays will change
			sum = 0;
		}
		System.out.println(maxSum +" <<<<<<<<maxSum");
	}
	
	// O(n) -- kadane's algorithm approach
	// Approach says: Lets assume, each element in array is a Gujrathi businessman..
	// Gujrathi community supports each other to grow their business
	// lets say two business mans joins together if their combined business value is greater than or equal to 0 ... 
	// Otherwise businessman will start his own business
	private static void kadaneAlgoApproach() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; //output should be 6;
		int maxSum = nums[0];
		int sum = nums[0];
		for(int i=1; i<nums.length;i++) {
			// join --  if the previous sum is 0 or greater than zero , new business will join 
			if(sum >= 0) {
				sum += nums[i];
			} else {
				// don't join -- if previous sum is less than zero new business will not join 
				sum = nums[i];
			}
			// check if sum is greater than maxSum -- override maxSum
			if(sum>maxSum) {
				maxSum = sum;
			}
			System.out.println("---Sum: "+sum + " | maxSum: "+maxSum);
		}
		System.out.println(maxSum +" <<<<<<<<maxSum");
	}

}
