package com.dsa.practice.amex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortVowelsInString {

	public static void main(String[] args) {
		//String str = "lEetcOde";
		//Output: "lEOtcede"
		/***
		 * Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. 
		 * The vowels are sorted according to their ASCII values, and the consonants remain in the same places
		 */
		
		//String str = "biuAAc";
		// Output: "bAAiuc"
		
		String str = "lYmpH";
		//Output: "lYmpH"
		
		String output = approach1(str);
		
		System.out.println("approach1 output: "+output);
		
		output = approach2(str);
		
		System.out.println("approach2 output: "+output);
	}
	
	// time complexity O(n log n) -- sorting of vowels
	// space complexity : O(n)
	private static String approach2(String str) {
		
		String vowelsString = "AEIOUaeiou";
		int j = 0;
		
		Map<Character, Integer> vowelsMap = new HashMap<>();
		char[] chars = str.toCharArray();
		
		for(int i=0; i<chars.length;i++) {
			if(isVowel(chars[i])) {
				vowelsMap.put(chars[i], vowelsMap.getOrDefault(chars[i], 0) + 1);
			}
		}
		
		for(int i=0; i<chars.length;i++) {
			if(isVowel(chars[i])) {
				while (j < vowelsString.length()) {
					if(vowelsMap.containsKey(vowelsString.charAt(j)) && vowelsMap.get(vowelsString.charAt(j)) != 0) {
						chars[i] = vowelsString.charAt(j);
						vowelsMap.replace(vowelsString.charAt(j), vowelsMap.getOrDefault(chars[i], 0) - 1);
						break;
					} else {
						j++;
					}
				}
			}
		}
		
		//System.out.println("vowelsMap 2: "+vowelsMap);
		
		//System.out.println("chars: "+Arrays.toString(chars));
		
		return String.valueOf(chars);
	}
	

	// time complexity O(n log n) -- sorting of vowels
	// space complexity : O(n)
	private static String approach1(String str) {
		
		StringBuilder vowelsPresent = new StringBuilder();
		
		char[] inputArray = str.toCharArray();
		
		for(int i=0; i<inputArray.length;i++) {
			if(isVowel(inputArray[i])) {
				vowelsPresent.append(String.valueOf(inputArray[i]));
			}
		}
		
		// sort the vowels present
		char[] vowelsPresentArray = vowelsPresent.toString().toCharArray();
		Arrays.sort(vowelsPresentArray);
		
		int index = 0;
		for(int i=0; i<inputArray.length;i++) {
			if(isVowel(inputArray[i])) {
				inputArray[i] = vowelsPresentArray[index++];
			}
		}
		
		return String.valueOf(inputArray);
	}
	
	private static boolean isVowel(char ch) {
		return (ch=='A' || ch=='a' || ch=='E' || ch=='e' || ch=='I' || ch=='i' || ch=='O' || ch=='o' || ch=='U' || ch=='u');
	}

}
