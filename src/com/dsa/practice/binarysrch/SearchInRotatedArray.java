package com.dsa.practice.binarysrch;

public class SearchInRotatedArray {
	// MEDIUM
	// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=9035s -- Kunal Kushwaha
	// https://leetcode.com/problems/search-in-rotated-sorted-array
	public static void main(String[] args) {
		
		System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0)); // Output: 4
		
		System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3)); // Output: -1
		
	}

	private static int search(int[] nums, int target) {
		int pivot = findPivot(nums);

		// if you did not find a pivot, it means the array is not rotated
		if (pivot == -1) {
			// just do normal binary search
			return binarySearch(nums, target, 0, nums.length - 1);
		}

		// if pivot is found, you have found 2 asc sorted arrays
		if (nums[pivot] == target) {
			return pivot;
		}

		if (target >= nums[0]) {
			return binarySearch(nums, target, 0, pivot - 1);
		}

		return binarySearch(nums, target, pivot + 1, nums.length - 1);
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			// find the middle element
			// int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				// ans found
				return mid;
			}
		}
		return -1;
	}

	// this will not work in duplicate values
	private static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			// 4 cases over here
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			}
			if (arr[mid] <= arr[start]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}

/*
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */