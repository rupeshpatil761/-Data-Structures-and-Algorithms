package com.dsa.practice.java8.functionalprogg;

import java.util.Arrays;
import java.util.List;

public class AllOrAnyOrNoneMatch {
	
	
	// All 3 are short circuting operations,
	// it stops processing as soon as it finds the first element that matches the predicate and returns the result
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5,8,6,12);
		boolean result = numbers.stream().allMatch(n -> n > 0);
		System.out.println("All Match Result : "+result);
		
		result = numbers.stream().anyMatch(n -> n > 13);
		System.out.println("Any Match Result : "+result);
		
		result = numbers.stream().noneMatch(n -> n < 0);
		System.out.println("None Match Result : "+result);
	}

}
