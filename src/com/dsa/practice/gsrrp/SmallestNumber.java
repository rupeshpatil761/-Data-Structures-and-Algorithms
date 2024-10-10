package com.dsa.practice.gsrrp;

public class SmallestNumber {

	public static void main(String[] args) {
		// Returns the smallest number in array that has been rotated
		// For example - Array {3,4,5,6,1,2} returns 1
		// Input array was originally sorted in increasing orders
		// FindMinInArray must have O(log n) runtime
		// Input array does not have any duplicates
		
		//Input: [3, 4, 5, 6, 1, 2]Output: 1
		//Input: [2, 1]Output:
		
		int[] array = {3,4,5,6,1};
		
		int start = 0;
		int end = array.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			//if(mid <)
		}
		
	}

}
