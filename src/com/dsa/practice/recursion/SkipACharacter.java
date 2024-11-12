package com.dsa.practice.recursion;

public class SkipACharacter {
	
	// skip all a's from string

	public static void main(String[] args) {
		String input = "baccad";
		skip("", input);
	}
	
	private static void skip(String ans, String input) {
		
		if(input.isEmpty()) {
			System.out.println(ans);
			return;
		}
		
		char ch = input.charAt(0);
		
		if(ch=='a') {
			skip(ans, input.substring(1));
		} else {
			skip(ans + ch, input.substring(1));
		}
	}

}
