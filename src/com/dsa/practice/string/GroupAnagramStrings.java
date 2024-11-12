package com.dsa.practice.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagramStrings {

	/**
	 * Group and print similar strings as list in java 8 
	 * Example:
	 * String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
	 * Output:
	 * ["abcd" , "dcba"]
	 * ["java", "ajav"]
	 * ["epam", "pame", "aepm"]
	 */
	
	public static void main(String[] args) {
		
		String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
		
		Function<String, String> sortFunction = (str) -> { 
			char[] array1 = str.toCharArray();
			Arrays.sort(array1);
			return new String(array1);
		};
		
		Map<String, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(sortFunction, LinkedHashMap::new, Collectors.toList()));
		
		System.out.println("map: "+map);
		
		map.values().stream().filter(value -> value.size() > 1).forEach(System.out::println);
		
		System.out.println("-------------------------------------------------");
		
		grouingByFrequencyString(arr);
	}
	
	private static void grouingByFrequencyString(String arr[]) {
		/**
		 * example;
		 * For abcd and dcba --> frequency string is a1b1c1d1 -- so both can be grouped using freq string
		 */
		//System.out.println(getFreqString("abcd"));
		
		Function<String, String> freqStringFunction = (str) -> {
			int[] numsArray = new int[26];
			for(char ch : str.toCharArray()) {
				numsArray[ch - 'a']++;
			}
			StringBuilder freqString = new StringBuilder();
			char ch = 'a';
			for(int n : numsArray) {
				if(n!=0) {
					freqString.append(ch+"");
					freqString.append(n+"");
				}
				ch++;
			}
			return freqString.toString();
		};
		
		Map<String, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(freqStringFunction, Collectors.toList()));
		
		System.out.println("grouingByFrequencyString map : "+map);
		
	}
}
