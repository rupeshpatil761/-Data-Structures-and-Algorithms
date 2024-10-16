package com.dsa.practice.recursion;

public class SortedArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7,6};
		boolean ans = sorted(arr, 0);
		System.out.println("Ans: "+ans);
	}

	private static boolean sorted(int[] arr, int i) {
		if(i == arr.length-1) {
			return true;
		}
		return arr[i] < arr[i+1] && sorted(arr, i+1);
	}

}
