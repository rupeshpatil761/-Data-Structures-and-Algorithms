package com.dsa.practice.java8.streams;

import java.util.function.Function;

public class FunctionExample {
	
	// Function takes two arguments T & R 
	// @param t the function argument or input
    // @return the function result

	public static void main(String[] args) {
        Function<Integer, Double> sqrt = n -> Math.sqrt(n);
        System.out.println("Square root of 64: " + sqrt.apply(64));
        System.out.println("Square root of 81: " + sqrt.apply(81));

        Function<String,String> lowercaseFunction = s1 -> s1.toLowerCase();
        System.out.println(lowercaseFunction.apply("PROGRAMMING"));
        Function<String, String> concatFunction = (s) -> s.concat(" In Java");

        System.out.println(lowercaseFunction.andThen(concatFunction).apply("PROGRAMMING"));
        System.out.println(lowercaseFunction.compose(concatFunction).apply("PROGRAMMING"));
    }
}
