package com.dsa.practice.string;

import java.util.Arrays;

public class StringCompression {
	
	// https://leetcode.com/problems/string-compression/description/
	
	public static void main(String[] args) {
		solution1(new char[] {'a','a','b','b','c','c','c'});
		//solution2(new char[] {'a','a','b','b','c','c','c'});
		
		char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		solution1(chars2);
		
		char[] chars3 = {'a'};
		solution1(chars3);
		solution2(new char[] {'a'});
	}
	
	// without stringbuilder
	// https://www.youtube.com/watch?v=cAB15h6-sWA
	private static void solution2(char[] chars) {
		int n = chars.length;
		int index = 0;
		for(int i=0; i<n; i++) {
			char ch = chars[i];
			int count = 0;
			while(i < n && ch==chars[i]) {
				count++;
				i++;
			}
			// count == 1 --> keep the string as it is 
			// or count > 1  --> append ch and the count next to it
			if(count==1) {
				chars[index++] = ch;
			} else {
				chars[index++] = ch;
				char[] countArray = String.valueOf(count).toCharArray();
				for(char digit : countArray) {
					chars[index++] = digit;	
				}
			}
			i--;
		}
		System.out.println("solution2 Result string length : "+index);
		System.out.println("solution2 Resulting array : "+Arrays.toString(chars));
	}
	
	// uSing stringBuilder
	// https://www.youtube.com/watch?v=-E5n_ESjCQA
	private static void solution1(char[] chars) {
		int n = chars.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			char ch = chars[i];
			int count = 1;
			while(i < n-1 && ch==chars[i+1]) {
				count++;
				i++;
			}
			// count == 1 --> keep the string as it is 
			// or count > 1  --> append the count next to string
			if(count==1) {
				sb.append(ch+"");
			} else {
				sb.append(ch+"");
				sb.append(count);
			}
		}
		for(int i=0; i < sb.length(); i++) {
			chars[i] = sb.charAt(i);
		}
		System.out.println("solution1 Result string length : "+sb.length());
		System.out.println("solution1 Resulting array : "+Arrays.toString(chars));
	}
}
/*
Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3"

Example 2:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

*/