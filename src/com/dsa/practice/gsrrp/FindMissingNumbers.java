package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class FindMissingNumbers {

	public static void main(String[] args) {
		int nums[] = {1,2,3,5,6};
		System.out.println("Input array is "+Arrays.toString(nums));
		
		int M=Integer.MIN_VALUE;
        for(int i:nums){
            if(i>M){
                M=i;
            }
        }
        System.out.println(M+" <<<<< M"); // maximum value in input array
		
		int[] tempArray = new int[M]; // size of array will be depend on max number in array
		
		for(int e : nums) {
			tempArray[e-1] = 1; // mark all present numbers with 1
		}
		
		// print missing numbers
		System.out.println("tempArray: "+Arrays.toString(tempArray));
		for (int j = 0; j < tempArray.length; j++) {
			if (tempArray[j] == 0) {
				System.out.println("Missing no is: " + (j+1));
			}
		}
	}

}
