package com.dsa.practice.string;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {

	public static void main(String[] args) {

		/*
		 * String s = "foo"; String t = "bar";
		 */

		String s = "badc";
		String t = "baba";

		System.out.println("Result: " + isIsomorphicUsingMap(s, t));
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
				if (map.containsKey(s.charAt(i)) && !map.get(s.charAt(i)).equals(t.charAt(i)) || 
						!map.containsKey(s.charAt(i)) && map.values().contains(t.charAt(i))) {
						result = false;
						break;
				} else {
					map.put(s.charAt(i), t.charAt(i));
				}
			}
		}
		return result;
	}

}
