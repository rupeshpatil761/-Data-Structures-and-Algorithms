package com.dsa.practice.string;

public class FirstOccuranceIndexInString {

	public static void main(String[] args) {

		/***
		 * Input: haystack = "sadbutsad", needle = "sad" 
		 * Output: 0 
		 * Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0
		 */
		String haystack = "sadbutsad";
		String needle = "but";
		//String haystack = "leetcode";
		//String needle = "leeto";
		//String haystack =  "mississippi"; // ---to handle this case , added this condition haystack.length() - needle.length())+1
		//String needle = "issipi";
		//String haystack = "a";
		//String needle = "a";
		int startIndex = -1;
		 if(needle.length() > haystack.length()) {
			 System.out.println("First Index: "+startIndex);
	           return;
        }
		for(int i=0; i < (haystack.length() - needle.length())+1; i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				String subStr = haystack.substring(i, needle.length()+i);
				if(subStr.equals(needle)) {
					startIndex = i;
					System.out.println("subStr: " +subStr + " and i: "+i);
					break; 
				}
			}
		}
		System.out.println("First Index: "+startIndex);
	}

}
