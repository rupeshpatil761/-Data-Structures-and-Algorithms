package com.dsa.practice.recursion;

public class RotatedBinarySearch {
	
	public static void main(String[] args) {
		int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println(search(arr, 4, 0, arr.length - 1));
	}

	static int search(int[] arr, int target, int s, int e) {
		if (s > e) {
			return -1;
		}

		int m = s + (e - s) / 2;
		if (arr[m] == target) {
			return m;
		}

		// check if start to mid array is sorted or not?
		if (arr[s] <= arr[m]) {
			// check if target is present in first half
			if (target >= arr[s] && target <= arr[m]) {
				return search(arr, target, s, m - 1);
			} else {
				//check if target is present in second half
				return search(arr, target, m + 1, e);
			}
		}
		//check if target is present in second half
		if (target >= arr[m] && target <= arr[e]) {
			return search(arr, target, m + 1, e);
		}
		// check if target is present in first half
		return search(arr, target, s, m - 1);
	}

}
