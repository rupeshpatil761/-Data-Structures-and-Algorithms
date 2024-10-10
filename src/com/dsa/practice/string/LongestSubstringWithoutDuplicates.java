package com.dsa.practice.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {

	// https://neetcode.io/problems/longest-substring-without-duplicates
	
	// Given a string s, find the length of the longest substring without duplicate characters.

    // A substring is a contiguous sequence of characters within a string.

	// Example 1:

	// Input: s = "zxyzxyz"

	// Output: 3
	
	// Example 2:

	// Input: s = "xxxx"

	// Output: 1
	
	public static void main(String[] args) {
		System.out.println("Result: "+ lengthOfLongestSubstring("zxyzxyz"));
	}
	
	private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
