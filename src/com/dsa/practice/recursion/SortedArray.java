package com.dsa.practice.recursion;

public class SortedArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7,6};
		boolean ans = sorted(arr, 0);
		System.out.println("Ans: "+ans);
	}

	private static boolean sorted(int[] arr, int index) {
		// base condition
		if(index == arr.length-1) {
			return true;
		}
		return arr[index] < arr[index+1] && sorted(arr, index+1);
	}

}
