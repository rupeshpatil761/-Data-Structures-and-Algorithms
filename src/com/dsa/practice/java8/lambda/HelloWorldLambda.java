package com.dsa.practice.java8.lambda;

public class HelloWorldLambda {

	public static void main(String[] args) {
		
		TestInterface testInterface1 = () -> {
			return "Hello World";
		};
		
		System.out.println(testInterface1.printMessage() + " <<<<< Approach 1");
		
		// No need to put return keyword and curly braces
		TestInterface testInterface2 = () -> "Hello World";
		
		System.out.println(testInterface2.printMessage() + " <<<<< Approach 2");
		
	}

}
