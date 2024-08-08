package com.dsa.practice.arrays;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] array = {2,4,5,7,10,13,15,1,6};
		
		int start = 0;
		int end = array.length - 1;
		
		System.out.println("before reverse: "+Arrays.toString(array));
		
		while (start<end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		
		System.out.println("after reverse: "+Arrays.toString(array));
	}

}
