package com.dsa.practice.arrays;

import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {
	
	// https://www.youtube.com/watch?v=0H6038ldSyg 
	// https://leetcode.com/problems/merge-sorted-array/
	// Two Pointer approach
	// time complexity: O(m+n) -- We are iterating through both arrays once, so the time complexity is O(m+n).
	// space complexity: o(1)
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0}; // {0};
		int m = 3; // elements present in nums1 // 0;
		int[] nums2 = {2,5,6}; // {1};
		int n = 3; // elements present in nums2  //1
		int[] result =  merge(nums1, m, nums2, n);
		
		System.out.println("Result: "+Arrays.toString(result));
	}
	
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1; // nums1
		int j = n -1; // nums2
		int k = m + n -1; // to fill zero's
		while (j>=0) {
			if(i >=0 && nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				k--;
				i--;
			} else {
				nums1[k] = nums2[j];
				k--;
				j--;
			}
		}
		return nums1;
    }

}
