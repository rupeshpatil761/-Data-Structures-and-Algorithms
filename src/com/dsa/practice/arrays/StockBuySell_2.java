package com.dsa.practice.arrays;

public class StockBuySell_2 {
	
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii 	

	public static void main(String[] args) {
		int[] nums = { 7,6,4,3,1 };

		bestApproach(nums);
	}

	// time complexity : O(n)
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


/*
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
*/