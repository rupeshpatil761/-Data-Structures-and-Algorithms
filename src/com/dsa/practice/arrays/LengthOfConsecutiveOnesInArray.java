package com.dsa.practice.arrays;

public class LengthOfConsecutiveOnesInArray {

	/**
	 *  Input: nums = [1,1,0,1,1,1]
		Output: 3
		Explanation: The first two digits or the last three digits are consecutive 1s. 
		The maximum number of consecutive 1s is 3.
		
		https://leetcode.com/problems/max-consecutive-ones/description/
		
		https://www.youtube.com/watch?v=pPVE4KZ1hsU 
		
		
	 */
	
	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		int count = 0;
		int maxCount = 0;
		for (int i=0; i < nums.length; i++) {
			if(nums[i] == 1) {
				count ++;
				maxCount = Math.max(maxCount, count);
			} else {
				count = 0;
			}
		}
		System.out.println("consecutive 1's count is : "+maxCount);
	}
}
