package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class LongestUniformSubstring {

	// Example:
	// "10000111" => [ 1, 4 ] --- 0 is longest repeated and its indexes
	// "aabbbbbCdAA" => [ 2, 5 ] --- b is longest repeated and its indexes

	// Time Complexity O(n)
	// Space Complexity: O(1)
	public static void main(String[] args) {

		solution("aabbbc");
		solution("rupessssh");
		solution("abbbccda");
		solution("10000111");
		solution("aabbbbbCdAA");
	}

	private static void solution(String input) {
		// Edge case: if the string is empty or null
		if (input == null || input.isEmpty()) {
			System.out.println("Input: " + input + " | Result: " + Arrays.toString(new int[] { -1, 0 }));
		}

		// Variables to track the longest sequence
		int start = 0; // Start index of the longest sequence
		int maxLength = 1; // Length of the longest sequence
		int currentStart = 0; // Start index of the current sequence
		int currentLength = 1; // Length of the current sequence

		// Iterate through the string starting from the second character (index 1)
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				// Same character as previous one, so increase the sequence length
				currentLength++;
			} else {
				// Sequence ended, check if the current sequence is the longest
				if (currentLength > maxLength) {
					maxLength = currentLength;
					start = currentStart;
				}
				// Reset for the next sequence
				currentStart = i;
				currentLength = 1;
			}
		}

		// Final check for the last sequence (in case the longest is at the end)
		if (currentLength > maxLength) {
			maxLength = currentLength;
			start = currentStart;
		}

		int[] result = new int[] { start, maxLength };
		System.out.println("Input: " + input + " | Result: " + Arrays.toString(result));
	}

}
