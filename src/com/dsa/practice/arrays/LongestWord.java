package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LongestWord {
	
	/**
	 * LongestWord(sen) take the sen parameter being passed and return the longest word in the string. 
	 * If there are two or more words that are the same length, 
	 * return the first word from the string with that length. 
	 * Ignore punctuation and assume sen will not be empty. 
	 * Words may also contain numbers, 
	 * for example "Hello world123 567"
	 * Output: world123
	 */

	public static void main(String[] args) {
		String str = "fun&!! time";
		
		str = "I love dogs";
		
		java8approach(str);
		
		approach2(str);
				
	}

	private static void java8approach(String str) {
		if(str == null || str.length() < 1) {
			return;
		}

		// remove special chars
		str = str.replaceAll("[-+.^:,!&]","");
		
		if(str == null || str.length() < 1) {
			return;
		}
		
		Map<String, Integer> map = new HashMap();
		for (String word : str.split(" ")) {
			map.put(word, word.length());
		}
		
		Optional<String> longestWord = map.entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).map(entry -> entry.getKey()).findFirst();
		
		//Optional<String> longestWord1 = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::comparingByValue)).map(entry -> entry.getKey()).reduce((a,b) -> a.length() > b.length() ? a:b);
		
		System.out.println(longestWord.get() +" <<<<<<<<java8approach longest word");

	}

	private static void approach2(String str) {
		if(str == null || str.length() < 1) {
			return;
		}

		// remove special chars
		//str = str.replaceAll("[-+.^:,!&]","");
		
		str = str.replaceAll("[^a-z0-9A-Z ]","");
		
		if(str == null || str.length() < 1) {
			return;
		}
		
		String maxLengthWord = str.split(" ")[0];
		
		for (String word : str.split(" ")) {
			if(word.length() > maxLengthWord.length()) {
				maxLengthWord = word;
			}
		}
		
		System.out.println(maxLengthWord +" <<<<<<<<approach2 longest word");
	}
}
