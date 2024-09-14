package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class FindMissingSingleNumber {

	public static void main(String[] args) {
		int nums[] = {1,2,4,5,6};
		
		System.out.println("Input array is "+Arrays.toString(nums));
		
		int sum = 0;
		for (int i=0; i < nums.length; i++) {
			sum+=nums[i];
		}
		
		// find actual sum
		int n = nums.length;
		int actualSum = (n*(n+1))/2;
		
		int missingNum = actualSum - sum;
		
		System.out.println("Missing number: "+Math.abs(missingNum));
	}

}
