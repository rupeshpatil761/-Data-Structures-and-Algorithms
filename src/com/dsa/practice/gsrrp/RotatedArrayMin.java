package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class RotatedArrayMin {

	// Time Complexity: O(log n) – The binary search efficiently narrows down the search space.
    // Space Complexity: O(1) – The space complexity is constant as no extra space is required.
	public static void main(String[] args) {
		int[] array = {3, 4, 5, 6, 1, 2};
		System.out.println("Input array: "+Arrays.toString(array));
		int left = 0;
		int right = array.length - 1;
		
		while (left < right) {
			// find mid
			int mid = (left + right) / 2;
			
			// check if mid is smallest
			if(array[mid] > array[right]) {
				// means element is present in right half
				left =  mid +1;
			} else {
				// means element is present in left half
				right = mid;
			}
		}
		
		System.out.println("left: "+left +" | right: "+right);
		
		System.out.println("Smallest No from array is : "+array[left]);
		
		System.out.println("================");
		
		findMaxElement(array);
	}
	
	
	public static void findMaxElement(int[] array) {
		System.out.println("Input array: "+Arrays.toString(array));
		int left = 0;
		int right = array.length -1;
		
		while (left < right) {
			// find mid
			int mid = (left + right) / 2;
			
			// check if mid is smallest
			if(array[mid] > array[right]) {
				// means element is present in right half
				left =  mid;
			} else {
				// means element is present in left half
				right = mid -1;
			}
		}
		
		System.out.println("left: "+left +" | right: "+right);
		
		System.out.println("Maximum No from array is : "+array[left]);
	}
	

}
