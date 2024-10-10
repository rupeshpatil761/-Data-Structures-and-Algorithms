package com.dsa.practice.binarysrch;

public class BinarySearch {

	public static void main(String[] args) {
		// array must be sorted to use Binary search
		int[] array = {1,2,4,5,6,8,9,12,14,15,17};
		int target = 9;
		
		int result  = findIndexOfElement(array, target);
		
		System.out.println("Result: "+result);
	}
	
	private static int findIndexOfElement(int[] array, int target) {
		int start = 0;
		int end  = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(target < array[mid]) {
				end = mid - 1;
			} else if(target > array[mid]) {
				start = mid + 1;
			} else {
				return mid; 
			}
		}
		return -1;
	}

}
