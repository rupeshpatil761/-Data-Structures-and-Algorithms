package com.dsa.practice.arrays;

import java.util.Arrays;

public class RotateArrayToLeft {
	
	//https://www.youtube.com/watch?v=oABQlhrhXzg -- to rotate left
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};  // output: 3,4,5,1,2
		int k = 2;
		
		System.out.println("RotateArrayToLeft by k : " + k +" | before rotate:  "+Arrays.toString(array));
		
		rotate(array, k);
		
		System.out.println("RotateArrayToLeft by k : " + k +" | after rotate:  "+Arrays.toString(array));
	}
	
	private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // 0 to k rotate
        reverseArray(nums, 0, k-1);

        // k to n-1 rotate
        reverseArray(nums, k, n-1);
        
        // full rotate
        reverseArray(nums, 0, n-1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start]  = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Given an integer array nums, rotate the array to the left by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5], k = 2
Output: [3,4,5,1,2]
Explanation:
rotate 1 steps to the right: [2,3,4,5,1]
rotate 2 steps to the right: [3,4,5,1,2]

*/
