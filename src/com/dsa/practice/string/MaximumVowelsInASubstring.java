package com.dsa.practice.string;

import java.util.HashSet;
import java.util.Set;

public class MaximumVowelsInASubstring {

	public static void main(String... args) {
		String s = "abciiidef";
		int k = 3;
		System.out.println("Result: " + maxVowels(s, k));
		
		
		s = "aeiou";
		k = 2;
		System.out.println("Result: " + maxVowels(s, k));
		
		
		s = "leetcode";
		k = 3;
		System.out.println("Result: " + maxVowels(s, k));

	}
	
	/***
	 * Time Complexity: O(n)
	 * Space: O(1)
	 */
	private static int maxVowels(String s, int k) {
		int maxVowels = 0;
		int windowVowels = 0;

		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');

		// Count the number of vowels in the first window
		for (int i = 0; i < k; i++)
			if (vowels.contains(s.charAt(i)))
				windowVowels++;

		maxVowels = windowVowels;

		// Slide the window and update the maximum number of vowels
		for (int i = k; i < s.length(); i++) {
			if (vowels.contains(s.charAt(i - k)))
				windowVowels--;

			if (vowels.contains(s.charAt(i)))
				windowVowels++;

			maxVowels = Math.max(maxVowels, windowVowels);
		}

		return maxVowels;
	}
}
