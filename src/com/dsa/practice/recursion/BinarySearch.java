package com.dsa.practice.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,22};
		int target = 22;
		int result = search(array, target, 0, array.length-1);
		System.out.println("Result: "+result);
	}

	private static int search(int[] array, int target, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		
		int mid = start + (end - start) / 2;
		
		if(array[mid] == target) {
			return mid;
		}
		
		if(target < array[mid]) {
			return search(array, target, start, mid - 1);
		}
		
		return search(array, target, mid +1, end);
	}

}
