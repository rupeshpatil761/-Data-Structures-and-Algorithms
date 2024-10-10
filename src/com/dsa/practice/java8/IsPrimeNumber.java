package com.dsa.practice.java8;

import java.util.stream.Stream;

public class IsPrimeNumber {

	public static void main(String[] args) {
		//  Check if a list of integers contains a prime number using Java streams:
		
		Stream intStream = Stream.of(1,2,3,4,5,6,7,8,9);
		
		//intStream.anyMatch(IsPrimeNumber::isPrime);
		
	}
	
	private static boolean isPrime(int num) {
		
		return false;
	}

}
