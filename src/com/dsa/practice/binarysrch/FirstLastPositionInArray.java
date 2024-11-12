package com.dsa.practice.binarysrch;

import java.util.Arrays;

public class FirstLastPositionInArray {
	
	// MEDIUM
	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
	public static void main(String[] args) {
		//Input: nums = [5,7,7,8,8,10], target = 8	| Output: [3,4]
		//{5,7,7,7,7,8,8,10};  //7; | o/p 1,4
		int[] array = {5,7,7,8,8,10};
		int target = 8;;
		
		int[] result = bruteForceApproach(array, target);
		
		System.out.println("BruteForce O(n) Result: "+Arrays.toString(result));
		
		result = findFirstLastPosition(array, target);
		
		System.out.println("best approach O (log n) Result: "+Arrays.toString(result));
	}

	// optimized solution
	private static int[] findFirstLastPosition(int[] array, int target) {
		int[] ans = {-1,-1};
		ans[0] = binarySearch(array, target, true);
		if(ans[0] != -1) {
			ans[1] = binarySearch(array, target, false);
		}
		return ans;
	}
	
	private static int binarySearch(int[] array, int target, boolean findFirstIndex) {
		int ans = -1;
		int start = 0;
		int end = array.length-1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if(target < array[mid]) {
				end = mid -1;
			} else if (target > array[mid]){
				start = mid +1;
			} else {
				// potential ans found
				ans = mid;
				// There is possibility target value could be found on left side if we are trying to find first index
				// vice versa for end index
				if(findFirstIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return ans;
	}
	
	
	// bruteForceApproach
	private static int[] bruteForceApproach(int[] array, int target) {
		int[] result = {-1,-1};
		int start = 0;
		int end = array.length-1;
		while (start <= end) {
			if (array[start] == target) {
				result[0] = start;
				result[1] = start;
				break;
			}
			start++;
		}
		while (end >= start) {
			if (array[end] == target) {
				result[1] = end;
				break;
			}
			end--;
		}
		return result;
	}
}
