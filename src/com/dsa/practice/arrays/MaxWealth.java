package com.dsa.practice.arrays;

public class MaxWealth {

	public static void main(String[] args) {
		int[][] accounts = {{1,2,3},{3,2,1}};
		
		System.out.println("maximumWealth: "+maximumWealth(accounts));
	}

	private static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int account =0; account < accounts.length; account++) {
            int sum = 0;
            for(int bank = 0; bank < accounts[account].length; bank++) {
                sum += accounts[account][bank];
            }
            if(sum > maxWealth) {
                maxWealth = sum;
            }
        }
        return maxWealth;
    }
}
