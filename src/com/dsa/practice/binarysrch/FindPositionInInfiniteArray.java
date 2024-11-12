package com.dsa.practice.binarysrch;

public class FindPositionInInfiniteArray {
	
	// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

	public static void main(String[] args) {
		int[] array = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 170;
        int answer = findPosition(array, target);
        System.out.println("Answer: "+ answer);
	}
	
	private static int findPosition(int[] array, int target) {
		// first find the range
		// First start with box size of 2
		int start = 0;
		int end  = 1;
		// expand the range exponentially until target is within the range
		while(end < array.length && target > array[end]) {
			int temp = end + 1 ; // new start
			// double the box value and update end index
			// Ensure it does not exceed array bounds
			end = Math.min(end + (end - start + 1) * 2 , array.length -1);
			start = temp;
		}
		return binarySearch(array, target, start, end);
	}
	
	private static int binarySearch(int[] array, int target, int start, int end) {
		int ans = -1;
		while (start <= end) {
			int mid  = start + (end - start) / 2;
			if (target < array[mid]) {
				end = mid -1;
			} else if(target > array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return ans;
	}
	

}
