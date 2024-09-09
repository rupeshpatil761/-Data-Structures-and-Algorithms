package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeat {

	public static void main(String[] args) {

		String s = "geeksforgeeks";
		FirstNonRepeatChar(s);

		int arr[] = { 9, 4, 9, 6, 7, 4 };
		System.out.println("firstNonRepeatingNumber >>> "+firstNonRepeatingNumber(arr));
		
		java8Approach(s);
	}

	//s.indexOf(start, end)
	//Returns the index within this string of the first occurrence of the
    //specified character, starting the search at the specified index.
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
	
	public static void java8Approach(String str) {
		  // Step 1: Count occurrences of each character
        Map<Character, Long> charCountMap = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

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
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		// Traverse array again and return
		// first element with count 1.
		for (int i = 0; i < n; i++)
			if (map.get(arr[i]) == 1)
				return arr[i];
		return -1;
	}
}
