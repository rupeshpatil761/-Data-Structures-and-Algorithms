package com.dsa.practice.arrays;

public class LargestElement {

	public static void main(String[] args) {
		int[] nums = {2,5,6,1,8,9,3};
		int largest = nums[0];
		for(int i=1; i<nums.length;i++) {
			if(nums[i] > largest) {
				largest = nums[i];
			}
		}
		System.out.println(largest+ " <<< largest element");
	}

}
