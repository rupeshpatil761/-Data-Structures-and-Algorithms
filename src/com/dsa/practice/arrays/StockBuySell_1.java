package com.dsa.practice.arrays;

public class StockBuySell_1 {
	
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

	public static void main(String[] args) {
		int[] nums = {10,1,5,6,7,1};//7,1,5,3,6,4}; // 10,1,5,6,7,1
		linearComplexityApporach(nums);
		
		bestApproach(nums);
		
		maxProfit(nums);
	}
	
	// kadanes algo approach
	// T - O(n)
	// S - O(1)
	private static int bestApproach(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        System.out.println("kadanes algo approach | Max Profit: "+profit);
        return profit;
    }
	
	
	// time complexity : O(n)
	// space complexity : O(1)
	private static int maxProfit(int[] prices) {
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
