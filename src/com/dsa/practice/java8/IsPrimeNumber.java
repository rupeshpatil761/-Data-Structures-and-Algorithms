package com.dsa.practice.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsPrimeNumber {

	public static void main(String[] args) {
		//  Check if a list of integers contains a prime number using Java streams:
		
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6,7,8,9);
		
		List<Integer> primeNumbers = intStream.filter(n -> isPrime(n)).collect(Collectors.toList());
		
		System.out.println("primeNumbers: "+primeNumbers);
		
	}
	
	private static boolean isPrime(int n) {
        // Handle base cases
        if (n <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

}
