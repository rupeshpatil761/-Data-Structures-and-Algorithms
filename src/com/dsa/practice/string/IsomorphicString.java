package com.dsa.practice.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	
	// EASY https://leetcode.com/problems/isomorphic-strings/description/ 

	public static void main(String[] args) {

		
		String s = "foo"; String t = "bar";
		 

		/*
		 * String s = "egg"; String t = "add";
		 */

		System.out.println("isIsomorphicUsingMap Result: " + isIsomorphicUsingMap(s, t));
		
		System.out.println("isIsomorphicNew Result: " + isIsomorphicNew(s, t));
	}

	public static boolean isIsomorphic(String s, String t) {
		// Base case: for different length of two strings...
		if (s.length() != t.length())
			return false;
		// Create two maps for s & t strings...
		int[] map1 = new int[256];
		int[] map2 = new int[256];
		// Traverse all elements through the loop...
		for (int idx = 0; idx < s.length(); idx++) {
			// Compare the maps, if not equal, return false...
			if (map1[s.charAt(idx)] != map2[t.charAt(idx)])
				return false;
			// Insert each character if string s and t into seperate map...
			map1[s.charAt(idx)] = idx + 1;
			map2[t.charAt(idx)] = idx + 1;
		}
		return true; // Otherwise return true...
	}

	public static boolean isIsomorphicUsingMap(String s, String t) {
		boolean result = true;

		if (s.length() != t.length()) {
			result = false;
		}
		if (result) {
			HashMap<Character, Character> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i)) && !map.get(s.charAt(i)).equals(t.charAt(i))
						|| !map.containsKey(s.charAt(i)) && map.values().contains(t.charAt(i))) {
					result = false;
					break;
				} else {
					map.put(s.charAt(i), t.charAt(i));
				}
			}
		}
		return result;
	}

	public static boolean isIsomorphicNew(String s, String t) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (Integer i = 0; i < s.length(); i++) {
			if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i))
				return false;
		}
		return true;
	}

}
/*
String s = "foo";
String t = "bar";
output: false
Explanation: The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

String s = "egg";
String t = "add";
output: true

String s = "badc";
String t = "baba";  == false

*/
