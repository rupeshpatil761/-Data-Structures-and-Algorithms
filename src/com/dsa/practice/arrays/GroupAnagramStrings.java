package com.dsa.practice.arrays;

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
		
		
	}
}
