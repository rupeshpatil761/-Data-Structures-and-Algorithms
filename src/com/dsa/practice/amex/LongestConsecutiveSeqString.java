package com.dsa.practice.amex;

public class LongestConsecutiveSeqString {

	// https://www.youtube.com/watch?v=5ojjwFqEEtk 
	
	//https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/description/
	public static void main(String[] args) {
		
		/***
		 *  Input: s = "abacaba"
		    Output: 2
			Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
			"ab" is the longest continuous substring
		 */
		String str = "abacaba";
		int count = 1; // ***
		int maxCount = 0;
		int n = str.length();
		if(n==1) {
			System.out.println("Max Count: "+1);
			return;
		}
		char[] charArray = str.toCharArray();
		for(int i=1; i<charArray.length;i++) {
			if(charArray[i] - charArray[i-1] == 1) {
				count++;
			} else {
				count=1; // ***
			}
			maxCount = Math.max(maxCount, count);
		}
		
		System.out.println("Max Count: "+maxCount);
		
	}

}
