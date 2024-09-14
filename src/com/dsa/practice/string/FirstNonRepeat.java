package com.dsa.practice.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeat {

	public static void main(String[] args) {

		String s = "abacbef";//"geeksforgeeks";
		System.out.println("Input str: "+s);
		FirstNonRepeatChar(s);
		System.out.println("Result using freq array: " +firstUniqueCharacter(s));
		java8Approach(s);
		
		
		s="aabb";
		System.out.println("Input str: "+s);
		
		FirstNonRepeatChar(s);
		System.out.println("Result using freq array: " +firstUniqueCharacter(s));
		java8Approach(s);

		System.out.println("-------------------------------------------");
		
		int arr[] = { 9, 4, 9, 6, 7, 4 };
		System.out.println("firstNonRepeatingNumber >>> "+firstNonRepeatingNumber(arr));
	}

	//s.indexOf(start, end)
	//Returns the index within this string of the first occurrence of the
    //specified character, starting the search at the specified index.
	// ******* The approach you’re using can be improved for efficiency. Currently, 
	// it uses s.indexOf inside a loop, which leads to repeated scans of the string, making it less efficient
	
	// Time complexity : O(n2)
	public static void FirstNonRepeatChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			//System.out.println(s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) +" <<< "+s.charAt(i));
			if (s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1) {
				System.out.println("First non-repeating character is " + s.charAt(i));
				break;
			}
		}
		System.out.println("First non-repeating character is -1");
		return;
	}
	
	// ********** this is best approach
	// Using this approach improves efficiency by reducing the time complexity from O(n^2) to O(n), where n is the length of the string.
	// Time & space complexity : O(n)
	public static void java8Approach(String str) {
		  // Step 1: Count occurrences of each character
        Map<Character, Long> charCountMap = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // Step 2: Find the first non-repeating character
        Optional<Character> firstNonRepeating = str.chars()
            .mapToObj(c -> (char) c)
            .filter(ch -> charCountMap.get(ch) == 1)
            .findFirst();
        
        System.out.println("java8Approach -- firstNonRepeating: "+ (firstNonRepeating.isPresent() ? firstNonRepeating.get() : null));
	}

	static int firstNonRepeatingNumber(int arr[]) {
		// Insert all array elements in hash table
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
		}
		// Traverse array again and return
		// first element with count 1.
		for (int i = 0; i < n; i++)
			if (map.get(arr[i]) == 1)
				return arr[i];
		return -1;
	}
	
	// https://leetcode.com/problems/first-unique-character-in-a-string/description/
	private static char firstUniqueCharacter(String str) {
		int[] freq = new int[26];
		char[] chars = str.toCharArray();
		for(char ch: chars) {
			freq[ch-'a']++;
		}
		for(int i=0; i<chars.length;i++) {
			if(freq[chars[i]-'a']==1) {
				return chars[i];
			}
		}
		return '0';
	}
}
