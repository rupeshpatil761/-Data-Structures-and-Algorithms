package com.dsa.practice.arrays;

import java.util.Arrays;

public class GivenArraySortedOrNot {

	public static void main(String[] args) {
		int[] array = {2,4,5,10,17,13};
		
		boolean result = true;
		
		System.out.println("Given array : "+Arrays.toString(array));
		
		for(int i =1; i<array.length; i++) {
			if(array[i] < array[i-1]) {
				result = false;
				break;
			}
		}
		System.out.println("Is given array is sorted: "+result);
	}
}
