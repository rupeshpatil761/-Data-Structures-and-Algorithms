package com.dsa.practice.string;

import java.util.Arrays;

public class PangramProblem {
	
	// A sentence contains every single letter in the alphabet. Such sentences are called pangrams

	public static void main(String[] args) {
		
		String str = "The slow purple oryx meanders past the quiescent canine";
		
		String result = findMissingLetters(str);
		
		System.out.println("Result: "+result);
	}
	
	private static String findMissingLetters(String str) {
		
		int[] array = new int[26];
		
		char[] chars = str.toLowerCase().toCharArray();
		
		for(char ch : chars) {
			if(Character.isLetter(ch)) {
				array[ch - 'a'] = 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < array.length; i++) {
			if(array[i] == 0) {
				//System.out.print((char) (97 + i));
				sb.append((char) (97 + i));
			}
		}
		
		return sb.toString();
	}

}
