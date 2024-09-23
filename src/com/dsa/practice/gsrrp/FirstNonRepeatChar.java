package com.dsa.practice.gsrrp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatChar {

	public static void main(String[] args) {

		String s = "abacbef";//"geeksforgeeks";
		FirstNonRepeatChar(s);

		int arr[] = { 9, 4, 9, 6, 7, 4 };
		System.out.println("firstNonRepeatingNumber >>> "+firstNonRepeatingNumber(arr));
		
		java8Approach(s);
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
        
        System.out.println("java8Approach -- firstNonRepeating: "+firstNonRepeating.get());
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
}
