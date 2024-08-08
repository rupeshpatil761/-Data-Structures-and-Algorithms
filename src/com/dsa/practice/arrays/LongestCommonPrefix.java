package com.dsa.practice.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {

	/*
	 * Write a function to find the longest common prefix string amongst an array of
	 * strings. If there is no common prefix, return an empty string "".
	 * 
	 * Example 1:
	 * Input: strs = ["flower","flow","flight"] Output: "fl" 
	 * 
	 * Example 2: Input: strs
	 * = ["dog","racecar","car"] Output: ""
	 */
	
	//https://www.geeksforgeeks.org/longest-common-prefix-using-sorting/
	
	public static void main(String ...args) {
		String[] input = {"flower","flow","flight", "flowe","flig"};
		
		System.out.println("Longest Common Prefix is: "+findLongestCommonPrefix(input));
		
	}
	
	private static String  findLongestCommonPrefix(String[] input) {
		int size = input.length;

	    /* if size is 0, return empty string */
	    if (size == 0)
	        return "";

	    if (size == 1)
	        return input[0];
	    
	    System.out.println("Before sorting: "+Arrays.toString(input));
	    
	    // *******IMP
	    Arrays.sort(input);
	    
	    System.out.println("After sorting: "+Arrays.toString(input));
	    
	    // find the minimum length from first and last string
	    int minLengthWord = Math.min(input[0].length(), input[size-1].length());
	    
	    System.out.println("minLengthWord: "+minLengthWord);
	    
	    int i = 0;
	    
	    // compare the first letter of first string and last string from input sorted array
	    while(i < minLengthWord && input[0].charAt(i) == input[size-1].charAt(i)) {
	    	i++;
	    }
	    System.out.println("i: "+i);
	    
	    String prefix = input[0].substring(0,i);

	    return prefix;
	}

	
}
