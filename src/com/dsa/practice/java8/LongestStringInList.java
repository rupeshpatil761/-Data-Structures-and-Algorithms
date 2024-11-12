package com.dsa.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestStringInList {

	public static void main(String[] args) {
		
		List<String> strings = Arrays
	              .asList("apple", "banana", "cherry", "date", "grapefruit");
		
		/*Map<Integer, List<String>> map = strings.stream().collect(Collectors.groupingBy(String::length));
		
		Optional<String> longestString = map.entrySet().stream().sorted(Entry.comparingByKey((l1,l2) -> l2.compareTo(l1))).flatMap(entry -> entry.getValue().stream()).findFirst();
				
		System.out.println("map: "+map);
		
		System.out.println("longestString: " +longestString);*/
		
		// BEST APPROACH
		
		String longestString = strings.stream().max(Comparator.comparingInt(String::length)).orElse("");
		
		System.out.println("BEST SOLUTION longestString: " +longestString);
		
	}

}
