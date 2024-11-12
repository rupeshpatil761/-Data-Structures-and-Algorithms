package com.dsa.practice.binarysrch;

public class SearchInsertPosition {
	// EASY
	// https://leetcode.com/problems/search-insert-position/description/
	
	public static void main(String[] args) {
		// Input: nums = [1,3,5,6], target = 5 | Output : 2
		int[] array = {1,3,5,6};
		int target = 4;
		
		int start = 0;
		int end  = array.length - 1;
		
		int ans = -1;
		
		while (start <= end) {
			int mid  = start + (end - start) / 2;
			
			if(target < array[mid]) {
				end = mid -1;
			} else if(target > array[mid]) {
				start = mid + 1;
			} else {
				ans = mid;
				break;
			}
		}
		ans = start;
		System.out.println("Start: "+start +" | end: "+end);
		System.out.println("Insert position: "+ans);
	}

}
