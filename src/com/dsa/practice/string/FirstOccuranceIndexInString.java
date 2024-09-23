package com.dsa.practice.string;

public class FirstOccuranceIndexInString {

	public static void main(String[] args) {

		/***
		 * Input: haystack = "sadbutsad", needle = "sad" 
		 * Output: 0 
		 * Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0
		 */
		
		String hayStack = "leetcode";
		String needle = "leeto";
		int index = hayStack.indexOf(needle);
		
		System.out.println("Index: " +index);
	}

}
