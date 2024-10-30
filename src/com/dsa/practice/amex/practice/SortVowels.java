package com.dsa.practice.amex.practice;

import java.util.*;

public class SortVowels {

	  public static void main(String[] args) {
		  
		  
		  String str = "lEetcOde";
		  // Output: "lEOtcede"
		  
		  
		  /**
		   * approach 1
		   * Store all vowels in SB
		   * Sort the SB
		   * loop through original string -- if char is vowel -- replace it with SB char
		   * but time complexity is O(n log n )
		   */
		  
		  
		  /**
		   * Approach 2
		   * take a string of vowels
		   * loop through original string and store vowels in hashmap with its count
		   * if char is vowel
		   * loop through the vowelsString and check if count is > 0 replace it and update the count in map
		   */
		  
		  
		  Map<Character, Integer> vowelsCountMap = new HashMap<>();
		  
		  for(char ch : str.toCharArray()) {
			  if(isVowel(ch)) {
				  vowelsCountMap.put(ch, vowelsCountMap.getOrDefault(ch, 0) + 1);
			  }
		  }
		  
		  
		  String vowelsString = "AEIOUaeiou";
		  
		  int j = 0;
		  
		  char[] charArray = str.toCharArray();
		  
		  for(int i=0; i < charArray.length; i++) {
			  
			  if(isVowel(charArray[i])) {
				  
				  while(j < vowelsString.length()) {
					  
					  if(vowelsCountMap.containsKey(vowelsString.charAt(j)) && vowelsCountMap.get(vowelsString.charAt(j)) > 0) {
						  // replace vowel
						  charArray[i] = vowelsString.charAt(j);
						  // update count in map
							vowelsCountMap.replace(vowelsString.charAt(j),
									vowelsCountMap.getOrDefault(vowelsString.charAt(j), 0) - 1);
							break;
					  } else {
						  j++;
					  }
				  }
			  }
		  }
		  
		  str = String.valueOf(charArray);
		  
		  System.out.println("test | str: "+str);
		  
	  }
	  
	  private static boolean isVowel(Character ch) {
		  
		  ch = Character.toLowerCase(ch);
		  
		  return (ch=='a') || (ch=='e') || (ch=='i') || (ch=='o') || (ch=='u');
		  
	  }
}
