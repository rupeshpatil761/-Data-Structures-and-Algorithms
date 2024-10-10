package com.dsa.practice.gsrrp;

public class LongestUniformSubstring {

	
	// Time Complexity O(n)
	// Space Complexity: O(1)
	public static void main(String[] args) {
		String str = "aabbbc";
		
		str = "rupessssh";
		
		str = "abbbccda";
		
		
		// handle null and empty cases
		
		int currentLength = 1;
		int maxLength = 1;
		int currentIndex = 0;
		int maxIndex = 0;
		
		for(int i=0; i<str.length()-1; i++) {
			
			if(str.charAt(i) == str.charAt(i+1)){ 
				currentLength ++;
			} else {
				maxLength = Math.max(currentLength, maxLength);
				maxIndex = Math.max(currentIndex, maxIndex);
				currentLength = 1;
				currentIndex = i+1;
			}
		}
		System.out.println(currentLength+" <<<<<<<currentLength | currentIndex : "+currentIndex);
		System.out.println(maxLength+" <<<<<<<maxLength | maxIndex : "+maxIndex);
	}
}
