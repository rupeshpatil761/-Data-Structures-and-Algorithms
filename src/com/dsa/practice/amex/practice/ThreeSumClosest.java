package com.dsa.practice.amex.practice;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = {0,0,0};
		int target = 1;
		
		Arrays.sort(nums);
		
		int resultSum = nums[0] + nums[1] + nums[2]; 
		int minDifference = Integer.MAX_VALUE;
		
		for(int i=0; i<nums.length-2; i++) {
			
			int left = i + 1;
			int right = nums.length - 1;
			
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right]; 
				if(sum == target) {
					System.out.println("Result is: "+target);
					System.exit(0);
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				
				// find closest diff
				int diffToTarget = Math.abs(sum - target);
				if(diffToTarget < minDifference) {
					resultSum = sum;
					minDifference = diffToTarget;
				}
			} // end of while
		} // end for
		
		System.out.println("Result is: "+resultSum);
	}

}
