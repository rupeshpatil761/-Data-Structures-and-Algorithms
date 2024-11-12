package com.dsa.practice.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramStrings {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "ajva";

		System.out.println("String s1 : " + s1);
		System.out.println("String s2 : " + s2);

		System.out.println("sortingSolution result: " + sortingSolution(s1, s2));

		System.out.println("hashMapSolution result : " + hashMapSolution(s1, s2));
		
		System.out.println("isAnagramSolution3 using char[] result : " + isAnagramSolution3(s1, s2));

	}

	private static boolean sortingSolution(String s1, String s2) {
		if (s1.length() != s2.length()) {
			// System.out.println("Not Anagram!!");
			return false;
		}

		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();

		Arrays.sort(array1);
		Arrays.sort(array2);

		if (Arrays.equals(array1, array2)) {
			// System.out.println("Strings are Anagram!!");
			return true;
		} else {
			// System.out.println("Not Anagram!!");
			return false;
		}
	}

	private static boolean hashMapSolution(String s, String t) {
		Map<Character, Integer> count = new HashMap<>();

		// Count the frequency of characters in string s
		for (char x : s.toCharArray()) {
			count.put(x, count.getOrDefault(x, 0) + 1);
		}

		// Decrement the frequency of characters in string t
		for (char x : t.toCharArray()) {
			count.put(x, count.getOrDefault(x, 0) - 1);
		}

		// Check if any character has non-zero frequency
		for (int val : count.values()) {
			if (val != 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isAnagramSolution3(String s, String t) {
		int[] count = new int[26];

		// Count the frequency of characters in string s
		for (char x : s.toCharArray()) {
			count[x - 'a']++;
		}

		// Decrement the frequency of characters in string t
		for (char x : t.toCharArray()) {
			count[x - 'a']--;
		}

		// Check if any character has non-zero frequency
		for (int val : count) {
			if (val != 0) {
				return false;
			}
		}

		return true;
	}

}
