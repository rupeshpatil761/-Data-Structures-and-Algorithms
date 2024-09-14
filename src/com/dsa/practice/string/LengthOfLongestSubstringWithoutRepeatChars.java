package com.dsa.practice.string;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LengthOfLongestSubstringWithoutRepeatChars {

	public static void main(String[] args) {
		System.out.println("Result : "+lengthOfLongestSubstring("abcdabcbb"));
		
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
				// if we write dicrecty without using Character.value .. str.charAt(start) return ASCII value
				set.remove(Character.valueOf(str.charAt(start)));
				start++;
			}
		}
		
		return maxLength;
	}

}
