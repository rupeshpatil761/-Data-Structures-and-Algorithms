package com.dsa.practice.string;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatChars {

	public static void main(String[] args) {
		System.out.println("Result : "+lengthOfLongestSubstring("abcabcbb"));
		
		System.out.println("Result : "+lengthOfLongestSubstring("bbbbb"));
		
		System.out.println("Result : "+lengthOfLongestSubstring("pwwkew"));
	}
	
	// T: O(n) The add, remove, and contains operations are on average O(1) in a HashSet.
	// S: O(n) The space for the Set remains O(n)
	private static int lengthOfLongestSubstring(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		int start =0;
		int end =0;
		int maxLength = 0;
		Set<Character> set = new HashSet<>();
		
		while (end < str.length()) {
			if(!set.contains(str.charAt(end))) {
				set.add(str.charAt(end));
				end++;
				maxLength = Math.max(maxLength, set.size());
			} else {
				// if we write directly without using Character.value .. str.charAt(start) return ASCII value
				set.remove(Character.valueOf(str.charAt(start)));
				start++;
			}
			//System.out.println("start: "+start +" | end: "+end + " | Set: "+set);
		}
		return maxLength;
	}

}
/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/