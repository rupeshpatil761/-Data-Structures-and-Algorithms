package com.dsa.practice.gsrrp;

public class PalindromeNumber {

	public static void main(String[] args) {
		int number = 12321;
		boolean result = isPalindrome(number);

		System.out.println("Is the number " + number + " a palindrome? " + result);
		
		result = isPalindromeUsingStringBuilder(number);
		
		System.out.println("Is the number " + number + " a palindrome using SB? " + result);

	}

	// Time Complexity: O(log10N) – The number of digits in the integer determines
	// the time complexity since each digit is processed once.
	// Space Complexity: O(1) – No additional space is used aside from a few
	// variables.

	private static boolean isPalindrome(int number) {
		// Negative numbers are not palindromes
		if (number < 0)
			return false;

		// Numbers ending in zero (except zero itself) are not palindromes
		if (number % 10 == 0 && number != 0) {
			return false;
		}

		int originalNumber = number;
		int reversedNumber = 0;

		while (number > 0) {
			int digit = number % 10; // extract last digit
			reversedNumber = reversedNumber * 10 + digit; // Append it to the reversed number
			number /= 10; // Remove the last digit from number
		}

		return originalNumber == reversedNumber;
	}

	private static boolean isPalindromeUsingStringBuilder(int number) {
		// Convert the number to a string
		String numStr = Integer.toString(number);

		// Reverse the string and check if it is equal to the original string
		String reversedStr = new StringBuilder(numStr).reverse().toString();

		return numStr.equals(reversedStr);
	}

}
