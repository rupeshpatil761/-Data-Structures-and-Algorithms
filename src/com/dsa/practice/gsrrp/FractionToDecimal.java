package com.dsa.practice.gsrrp;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 3));   // Output: 0.(3)
		
		System.out.println(fractionToDecimal(-1, -3)); // Output: 0.(3)
		
		System.out.println(fractionToDecimal(-1, 2));  // Output: -0.5
	}

	// Time Complexity: O(d), where d is the denominator. This is because the loop for computing the decimal part and the HashMap operations are linear in relation to the denominator.
	// Space Complexity: O(d), where d is the denominator. This includes the space required for the result string and the HashMap to track remainders.
	 public static String fractionToDecimal(int numerator, int denominator) {
		 
		// Handle the case where numerator is 0
		 if(numerator==0) {
			 return "0";
		 }
		 
		// Handle edge case for division by zero
		 if(denominator==0) {
			 return "1";
		 }
		 
		 // determine the sign of the result (XOR) operation to identify any of the number is negative
		 StringBuilder result = new StringBuilder();
		 if((numerator < 0) ^ (denominator < 0)) {
			 result.append("-");
		 }
		 
		 // convert to absolute numbers
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);
		
		// compute integral part
		result.append(num / den);
		long remainder = num % den;
		
		// if there is no decimal part
		if(remainder == 0) {
			return result.toString();
		}
		
		result.append(".");
		
		System.out.println("Remainder: "+remainder + " | result.length(): "+result.length());
		
		// map to store position of the remainders
		Map<Long, Integer> remainderMap = new HashMap<>();
		remainderMap.put(remainder, result.length());
		
		while(remainder != 0) {
			remainder *= 10;
			result.append(remainder/den);
			remainder%=den;
			
			if(remainderMap.containsKey(remainder)) {
				int index = remainderMap.get(remainder);
				String integerPart = result.substring(0, index);
				String decimalPart = result.substring(index);
				return integerPart + "(" + decimalPart+")";
			}
			
			remainderMap.put(remainder, result.length());
		}
		 
		return result.toString();
	 }
}
