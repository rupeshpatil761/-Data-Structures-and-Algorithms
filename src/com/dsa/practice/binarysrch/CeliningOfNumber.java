package com.dsa.practice.binarysrch;

public class CeliningOfNumber {
	// EASY
	// ceiling - smallest number in array greater or equal to target
	// 
	public static void main(String[] args) {
		int[] array = {2,3,5,9,14,16,18};
		//int target = 4; // output should be index 2 i.e 5 value
		
		//int target = 15; // output should be index 5 i.e 16 value 
		
		int target = 20; // output should be -1
		
		int index = findCeling(array, target);
		System.out.println("Result index: "+index);
	}
	
	private static int findCeling(int[] array, int target) {
		
		int n = array.length;
		
		if(target > array[n-1]) {
			return -1;
		}
			
		int start = 0;
		int end = n -1;
		while (start <= end) {
			int mid  = start + (end - start) / 2; // to avoid out of int range in java
			if(target < array[mid]) {
				end = mid -1;
			} else if (target > array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		System.out.println("Start: "+start + " | end: "+end);
		return start;
	}

}
