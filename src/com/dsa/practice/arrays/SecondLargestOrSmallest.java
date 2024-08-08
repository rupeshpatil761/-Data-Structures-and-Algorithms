package com.dsa.practice.arrays;

public class SecondLargestOrSmallest {

	public static void main(String[] args) {
		
		int[] nums = {2,5,6,1,8,9,3};
		
		if(nums.length  < 2) {
			System.out.println("Please provide at least two elements in array");
			return;
		}
		
		int max1 = nums[0];
		int max2 = nums[1];
		
		if(max2>max1) {
			int temp = max1;
			max1 = max2;
			max2 = temp;
		}
		for(int i=2; i<nums.length;i++) {
			if(nums[i] > max1) {
				max2 = max1;
				max1 = nums[i];
			} else if (nums[i] > max2) {
				max2 = nums[i];
			}
		}
		System.out.println(max1+ " <<< largest element && second largest >> "+max2);
	}
	
	// https://www.youtube.com/watch?v=5babiA-TYhU&list=PLU83Ru7iGtAsnffw0XwxRq2c3itm4nwoC&index=2
}
