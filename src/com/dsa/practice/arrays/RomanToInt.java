package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	
	// https://leetcode.com/problems/roman-to-integer/description/

	public static void main(String[] args) {
		
		Map<Character,Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		String str = "MCMXCIV"; // output should be 1994
		// Output: 1994
		// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
		
		str = "III";  // o/p: 3
		int ans = 0;
		for(int i = 0; i < str.length(); i++) {
			int currentInt = map.get(str.charAt(i));
			if(i < str.length()-1 && currentInt < map.get(str.charAt(i+1))) {
				ans -= currentInt;
			} else {
				ans+= currentInt;
			}
		}
		
		System.out.println("Result: " +ans);
	}

}
/*
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/