package com.dsa.practice.arrays;

import java.util.Arrays;

public class RotateArrayToLeftOrRight {

	// https://www.youtube.com/watch?v=oABQlhrhXzg -- to rotate left
	
	// https://www.youtube.com/watch?v=ENcnXXiRT6E  -- to rotate right  -- leetcode 189
	
	// https://leetcode.com/problems/rotate-array/
	
	/*
	 * What does the rotation of the array mean?
	 * 
	 * Consider an array 1,2,3,4,5 Rotating this array by 1 in counterclockwise
	 * means the newly rotated array will be 2,3,4,5,1.
	 * 
	 * Similarly rotating this array by 2 counterclockwise means the newly rotated
	 * array will be 3,4,5,1,2.
	 * 
	 * So we have to write a program to rotate an array, by a given number k where
	 * the positive value of k denotes counterclockwise rotation and negative values
	 * of denote clockwise rotation.
	 */
	
	private static void reverseArray(int[] array, int start, int end) {
		while (start<end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};  // output: 23451
		int k = 3;
		int n = array.length;
		
		// to avoid extra rotations (for example, k value is positive, we have to move array to left 
		// if we move array 5 times we will get original array only
		// so to avoid extra rotations we take mod value in k
		
		// similarly, if k value is negative, which means we need to rotate array to right
		// to achieve that add the array length to k
		
		
		System.out.println("before reverse: "+Arrays.toString(array) + "   | original k : "+k);
		
		k = k % n;
		if(k<0) {
			k = k + n;
		}
		
		System.out.println(" Modified k : "+k);
		
		// first reverse the 0 to k-1 elements
		reverseArray(array, 0, k-1); 
		// 2nd reverse the k to n-1 i.e. end of array
		reverseArray(array, k, n-1);
		// finally reverse whole array i.e. o to end of array
		reverseArray(array, 0, n-1);
		
		System.out.println("after reverse by k : "+Arrays.toString(array));
		
		// time complexity is o(n)
		// even all above 3 calls executes n time i.e. 3n ..3 is constant so o(n)
	}
	
	// IMP ************ To reverse the array to right just do below
	// https://www.youtube.com/watch?v=ENcnXXiRT6E  -- to rotate right  -- leetcode 189
	// https://leetcode.com/problems/rotate-array/
	
	/**
	 * Rotate to RIGHT Example 1:
		Input: nums = [1,2,3,4,5,6,7], k = 3
		Output: [5,6,7,1,2,3,4]
		Explanation:
		rotate 1 steps to the right: [7,1,2,3,4,5,6]
		rotate 2 steps to the right: [6,7,1,2,3,4,5]
		rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 */
	
	//reverseArray(array, 0, n-k-1);
	//reverseArray(array, n-k, n-1);
	//reverseArray(array, 0, n-1);
}
