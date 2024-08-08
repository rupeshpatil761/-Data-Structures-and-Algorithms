package com.dsa.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	// leetcode: 217
	/**
	 * Given an integer array nums, return true if any value appears 
	 * at least twice in the array, and return false if every element is distinct.
	 */
	// https://www.youtube.com/watch?v=0LIctkgJ2hQ
	
	public static void main(String[] args) {
		boolean result = false;
		int[] nums = {1,2,3,4,2};
		Set<Integer> set = new HashSet<>();
		for (int i=0; i < nums.length; i++) {
			if(!set.add(nums[i])) {
				result = true;
				break;
			}
		}
		System.out.println("Contains Duplicate? "+result);
	}

}
