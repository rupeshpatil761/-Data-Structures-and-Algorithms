package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class FindSingleNumber {

	public static void main(String[] args) {
		int nums[] = {4,1,2,1,2};
		
		System.out.println("Input array is "+Arrays.toString(nums));
		
		int value = 0;
		
		for (int i=0; i < nums.length; i++) {
			value = value ^ nums[i]; // XOR operation -- if two numbers are different then returns non-zero value or number
		}
		
		System.out.println("Single number is "+value);
	}

}
