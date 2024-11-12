package com.dsa.practice.binarysrch;

public class FloorNumber {

	// EASY
	// floor - smallest number in array lesser or equal to target
	public static void main(String[] args) {
		int[] array = {2,3,5,9,14,16,18};
		int target = 4; // output should be index 1 i.e 3 value
		
		//int target = 15; // output should be index 4 i.e 14 value
		
		//int target =20; // output should be index -1
		
		int index = findFloor(array, target);
		System.out.println("Result index: "+index);
	}
	
	private static int findFloor(int[] array, int target) {
		int n = array.length;
		if(target > array[n-1]) {
			return -1;
		}
		
		int start = 0;
		int end = array.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if(target < array[mid]) {
				end = mid - 1;
			} else if(target < array[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return end;
	}

}
