package com.dsa.practice.arrays;

public class PalindromeChecker {

	public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false; // or true, depending on whether you consider an empty string a palindrome
        }

        // Normalize the string: convert to lowercase and remove non-alphanumeric characters
        String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the normalized string is equal to its reverse
        String reversedStr = new StringBuilder(normalizedStr).reverse().toString();

        return normalizedStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        String[] testStrings = {"A man, a plan, a canal, Panama", "racecar", "hello", "12321", "No lemon, no melon"};

        for (String test : testStrings) {
            System.out.println("\"" + test + "\" is palindrome: " + isPalindrome(test));
        }
    }
	
}
