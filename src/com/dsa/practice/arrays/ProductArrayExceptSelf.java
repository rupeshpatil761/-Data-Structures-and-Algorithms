package com.dsa.practice.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {

	// https://leetcode.com/problems/product-of-array-except-self
	// https://www.youtube.com/watch?v=G9zKmhybKBM
	// https://www.youtube.com/watch?v=ku4oITayEmk --good

	public static void main(String[] args) {

		divisionApproach(new int[] { 1, 2, 3, 4 });

		divisionApproach(new int[] { 1, 0, 9, 4 });

		divisionApproach(new int[] { 1, 0, 0, 4 });

		System.out.println("---------------------------------------------");

		extraSpaceApproach(new int[] { 1, 2, 3, 4 });
		
		extraSpaceApproach(new int[] { 1, 0, 9, 4 });

		extraSpaceApproach(new int[] { 1, 0, 0, 4 });
		
		System.out.println("---------------------------------------------");
		
		withoutSpaceApproach(new int[] { 1, 2, 3, 4 });
		
		withoutSpaceApproach(new int[] { 1, 0, 9, 4 });

		withoutSpaceApproach(new int[] { 1, 0, 0, 4 });

	}
	
	// Time complexity : O(n) Space complexity : O(1)
	private static void withoutSpaceApproach(int[] arr) {
		int[] result = new int[arr.length];
		int n = arr.length;
		
		result[0] = 1;
		for(int i=1; i < n; i++) {
			result[i] = result[i-1] * arr[i-1];
		}
		
		int rightProduct = 1;
		for(int i=n-1; i >= 0; i--) {
			result[i] = rightProduct * result[i];
			rightProduct = rightProduct * arr[i];
		}
		
		System.out.println("without extra space approach result: " + Arrays.toString(result));
	}

	// Time complexity : O(n) Space complexity : O(n)
	private static void extraSpaceApproach(int[] arr) {

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		left[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			left[i] = arr[i - 1] * left[i - 1];
		}

		right[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = arr[i + 1] * right[i + 1];
		}

		int[] result = new int[arr.length];

		for (int i=0; i < arr.length; i++) {
			result[i] = left[i] * right[i];
		}
		
		System.out.println("extra space approach result: " + Arrays.toString(result));
	}

	/**
	 * Time complexity : O(n) Space complexity : O(1) 
	 * In real interview - division may not be allowed
	 */
	private static void divisionApproach(int[] arr) {

		int[] result = new int[arr.length];

		int productWithoutZero = 1;
		int zeroCount = 0;

		for (int n : arr) {
			if (n == 0) {
				zeroCount++;
			} else {
				productWithoutZero *= n;
			}
		}
		int index = 0;
		for (int n : arr) {
			if (n == 0) {
				if (zeroCount > 1) {
					result[index++] = 0;
				} else {
					result[index++] = productWithoutZero;
				}
			} else {
				if (zeroCount > 0) {
					result[index++] = 0;
				} else {
					result[index++] = productWithoutZero / n;
				}
			}
		}

		System.out.println("divisionApproach result: " + Arrays.toString(result));
	}

}
