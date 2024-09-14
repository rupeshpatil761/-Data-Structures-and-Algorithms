package com.dsa.practice.string;

import java.util.Arrays;

public class AnagramStrings {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "ajva";
		
		System.out.println("String s1 : "+s1);
		System.out.println("String s2 : "+s2);
		
		if(s1.length() != s2.length()) {
			System.out.println("Not Anagram!!");
			return;
		}
		
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		if(Arrays.equals(array1, array2)) {
			System.out.println("Strings are Anagram!!");
		} else {
			System.out.println("Not Anagram!!");
		}
	}

}
