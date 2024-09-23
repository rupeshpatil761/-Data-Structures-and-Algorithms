package com.dsa.practice.arrays;

public class StockBuySell_2 {

	public static void main(String[] args) {
		int[] nums = { 7,6,4,3,1 };

		bestApproach(nums);
	}

	// time complexity : O(1)
	// space complexity : O(1)
	private static int bestApproach(int[] nums) {
		int profit = 0;
		// check if current day profit is more than yesterdays 
		// if yes -- do profit += currentValue - yesterdays value
		for(int i=1; i<nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				profit += nums[i] - nums[i-1]; 
			}
		}
		System.out.println("Max Profit: "+profit);
		return profit;
	}
}
