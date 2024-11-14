package com.dsa.practice.string;

public class LongestPalindromicSubstring {
	
	// https://leetcode.com/problems/longest-palindromic-substring/description/
	
	// https://www.youtube.com/watch?v=AKIHWGumagI&t=318s 

	public static void main(String[] args) {
		
		System.out.println("Result for babad is: "+findLongestSubstring("babad"));
		System.out.println("Result for cbbd is: "+findLongestSubstring("cbbd"));
		
	}
	
	private static String findLongestSubstring(String str) {
		if(str==null || str.length() < 1) {
			return "";
		}
		int max = 0;
		int n = str.length();
		int start=0;
		int end=0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(isPalindrome(str, i, j)) {
					if(j-i+1 > max) { // to find max substring if already maxSubString has found no need to check for small substrings
						max = j-i+1;
						start = i;
						end = j;
					}
				}
			}
		}
		return str.substring(start, end+1);
	}
	
	private static boolean isPalindrome(String str, int s, int e) {
		while (s < e) {
			if(str.charAt(s) != str.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}

}
/*

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

*/