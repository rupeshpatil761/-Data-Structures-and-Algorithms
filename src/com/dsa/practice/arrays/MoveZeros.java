package com.dsa.practice.arrays;

import java.util.Arrays;

public class MoveZeros {
	
	// https://www.youtube.com/watch?v=V0vmGwinHrg&t=314s
	
	// https://leetcode.com/problems/move-zeroes/description/
	
	//Given an integer array nums, move all 0's to the end of it 
	//while maintaining the relative order of the non-zero elements.

	//*** Note that you must do this in-place without making a copy of the array.
	
	/*
	 * Example 1: Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
	 */
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,0,3,12};
		//int[] nums = {4,2,4,0,0,3,0,5,1,0};
		
		solution2(nums);
		
	}
	
	private static void tapAcademySolution(int[] nums) {
		int size = nums.length;
		if(size==0 || size==1) {
			return;
		}
		int nz = 0; // non-zero element
		int z = 0; // zero element
		while (nz < size) {
			if(nums[nz] != 0) {
				int temp = nums[nz];
				nums[nz] = nums[z];
				nums[z] = temp;
				nz++;
				z++;
			} else {
				nz++;
			}
		}
		System.out.println("Solution1 Result: "+Arrays.toString(nums));
	}
	
	// https://www.youtube.com/watch?v=k5lIW5XxC7g
	// time: O(n)
	// space: O(1)
	// *****Simple and optimum solution
	private static void solution2(int[] nums) {
		// first fill position starting with zero with non-zero numbers
		// if insertPosition < length -- fill remaining with zero numbers
		
		int insertPosition = 0;
		for (int i=0; i<nums.length; i++) {
			// fill all non-zero numbers
			if(nums[i] != 0) {
				nums[insertPosition] = nums[i];
				insertPosition++;
			}
		}
		
		while (insertPosition < nums.length) {
			nums[insertPosition] = 0;
			insertPosition++;
		}
		
		System.out.println("Solution2 Result: "+Arrays.toString(nums));
	}

}
