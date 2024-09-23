package com.dsa.practice.arrays;

public class StockBuySell_1 {

	public static void main(String[] args) {
		int[] nums = {7,1,5,3,6,4};
		linearComplexityApporach(nums);
		
		bestApproach(nums);
	}
	
	
	// time complexity : O(1)
	// space complexity : O(1)
	private static int bestApproach(int[] prices) {
		System.out.println("inside bestApproach");
		int maxProfit = 0;
		int minSoFar = prices[0];
		
		for (int i=0; i < prices.length; i++) {
			minSoFar = Math.min(minSoFar, prices[i]);
			int profit = prices[i] - minSoFar;
			maxProfit = Math.max(maxProfit, profit);
		}
		System.out.println("Max Profit: "+maxProfit);
		return maxProfit;
	}
	
	
	// time complexity : O(n)
	// space complexity : O(n)
	private static int linearComplexityApporach(int[] nums) {
		System.out.println("inside linearComplexityApporach");
		// create new auxiliary array to store max number from right to left
		int[] auxArray = new int[nums.length];
		int maxNo = nums[nums.length-1]; 
		for(int i=nums.length-1; i>=0; i--) {
			maxNo = Math.max(maxNo, nums[i]);
			auxArray[i] = maxNo;
		}
		int i = 0;
		int maxProfit = 0;
		while (i < nums.length) {
			maxProfit = Math.max((auxArray[i] - nums[i]), maxProfit);
			i++;
		}
		System.out.println("Max Profit: "+maxProfit);
		return maxProfit;
	}

}
