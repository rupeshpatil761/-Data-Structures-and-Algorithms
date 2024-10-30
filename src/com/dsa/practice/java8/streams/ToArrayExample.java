package com.dsa.practice.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ToArrayExample {
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple","orange","cherry");
		
		String[] result = words.stream().toArray(String[]::new);
		
		System.out.println("Result array: "+Arrays.toString(result));
	}

}
