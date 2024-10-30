package com.dsa.practice.amex.practice;

import java.util.*;

public class TwoSum {
	/*
	 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
	 * Because nums[0] + nums[1] == 9, we return [0, 1].
	 */

	public static void main(String[] args) {
		
		//int[] nums = {2,7,11,15};
		//int target = 9;
		
		int[] nums = {3,3};
		int target = 6;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if(map.containsKey(complement)) {
				System.out.println("Pair: "+map.get(complement) +" | "+ i);
			}
			
			map.put(nums[i], i);
		}
		
	}
}
