package com.dsa.practice.gsrrp;

public class RunLengthEncoding {

	public static void main(String[] args) {
		
		System.out.println(runLengthEncoding("a"));         // Output: "a1"
        System.out.println(runLengthEncoding("aa"));        // Output: "a2"
        System.out.println(runLengthEncoding("aabbb"));     // Output: "a2b3"
        System.out.println(runLengthEncoding("aabbbaa"));   // Output: "a2b3a2"
        System.out.println(runLengthEncoding(""));          // Output: ""
		
	}

	// Time Complexity: O(n), where n is the length of the input string.
	// Space Complexity: O(n), primarily due to the storage used by the StringBuilder for the encoded string
	private static String runLengthEncoding(String str) {
		
		if(str == null || str.length() < 1) {
			return "";
		}
		
		int count = 1;
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				count++;
			} else {
				result.append(str.charAt(i));
				result.append(count);
				count = 1;
			}
		}
		
		// append last char of string
		result.append(str.charAt(str.length()-1)).append(count);
		return result.toString();
	}

}
