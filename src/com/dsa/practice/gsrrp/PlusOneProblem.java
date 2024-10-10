package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class PlusOneProblem {
	
	// https://leetcode.com/problems/plus-one/description/

	public static void main(String[] args) {
		//int[] inputArray = {1,2,3};
		//int[] inputArray = {4,3,2,1};
		int[] inputArray = {1,9};
		// output should be 123 + 1 = 124
		int[]  result = solution(inputArray);
		System.out.println("Resulting array: "+Arrays.toString(result));
	}

	private static int[] solution(int[] inputArray) {
		int n = inputArray.length;
		for (int i=n-1; i >= 0; i--) {
			if(inputArray[i] < 9) {
				inputArray[i]++;
				return inputArray;
			}
			inputArray[i]=0;
		}
		int[] newArray = new int[n+1];
		newArray[0] = 1;
		return newArray;
	}

}
