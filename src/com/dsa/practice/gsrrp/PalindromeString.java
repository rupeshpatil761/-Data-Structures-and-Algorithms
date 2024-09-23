package com.dsa.practice.gsrrp;

public class PalindromeString {

	public static void main(String[] args) {

		String str = "abba";
		System.out.println("Result: "+ solution(str));

	}
	// https://www.youtube.com/watch?v=ANmSVWeOsUA
	private static boolean solution(String str) {
		// Input should not be alphanumeric string
		str = str.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
