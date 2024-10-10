package com.dsa.practice.string;

import java.util.HashMap;

public class StringReducer {

	/***
	 * Given a string str and an integer K, the task is to reduce the string by
	 * applying the following operation any number of times until it is no longer
	 * possible. 
	 * Eg - K = 2, str = “geeksforgeeks” , Output - gksforgks 
	 * K = 3, str = “geeksforgeeks” , Output - geeksforgeeks 
	 * Approach and time complexities only."
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "geeksforgeeks";
		int k1 = 2;
		System.out.println("Reduced String 1: " + reduceString(str1, k1)); // Output: gksforgks

		String str2 = "geeksforgeeks";
		int k2 = 3;
		System.out.println("Reduced String 2: " + reduceString(str2, k2)); // Output: geeksforgeeks
	}

	
	// Time Complexity: O(m⋅n)
	// Space Complexity: O(1) (or O(n) if considering output storage)
	private static String reduceString(String str1, int k) {

		String result = str1;
		while (true) {
			
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            // Count character frequencies
            for (char c : result.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
            StringBuilder newResult = new StringBuilder();
            // Build the new string with allowed characters
            for (char c : result.toCharArray()) {
                if (frequencyMap.get(c) <= k) {
                    newResult.append(c);
                }
            }
            // If no characters were removed, we are done
            if (newResult.length() == result.length()) {
                break;
            }
            // Update result for the next iteration
            result = newResult.toString();
        }
        return result;
	}

}
