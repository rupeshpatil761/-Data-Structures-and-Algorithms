package com.dsa.practice.amex;

import java.util.Arrays;

public class CoinChange {
	
	//https://leetcode.com/problems/coin-change/description/

	public static void main(String[] args) {
		
		solution(new int[] {1,2,5}, 11); // Output: 3 | Explanation: 11 = 5 + 5 + 1
		
		System.out.println("-------------------------------");
		
		solution(new int[] {1,4,10}, 19); // Output: -1 | Explanation:
		
		//System.out.println("-------------------------------");
		
		//solution(new int[] {1}, 0); // Output: 0 | Explanation:
		
		//System.out.println("-------------------------------");
	}
	
	// Time complexity : O (M * N) where M is total coins and N is total amount
	// Space complexity : O (N)
	private static int solution(int[] coins, int amount) {
		
		System.out.println("Input Coins: "+Arrays.toString(coins));
		
		System.out.println("Input amount: "+amount);
		
		if(amount == 0) {
			System.out.println("Output min coins: 0");
			return 0;
		}
	
		int[] dp = new int[amount + 1];
		
		// try to find for each amount from 1 to Amount how many coins are required
		for (int i = 1; i <= amount; i++) {

			dp[i] = Integer.MAX_VALUE;
			
			// try with each coin to make i amount
			for (int coin : coins) {
				
				if(coin <= i && dp[i-coin] != Integer.MAX_VALUE) {
					
					dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
				}
			}
		}
		
		if(dp[amount] == Integer.MAX_VALUE) {
			System.out.println("Output min coins: -1");
			return -1;
		}
		
		System.out.println("DP: "+Arrays.toString(dp));
		
		System.out.println("Output min coins: "+dp[amount]);
		
		return dp[amount];
	}

}
