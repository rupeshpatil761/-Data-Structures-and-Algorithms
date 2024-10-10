package com.dsa.practice.binarysrch;

public class SmallestLetterGreaterThanTarget {

	// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
	
	public static void main(String[] args) {
		//char[] array = {'c','f','j'};
		//char target = 'a'; // output should be c
		
		char[] array = {'c','f','j'};
		char target = 'c'; // output should be f
		
		//char[] array = {'x','x','y','y'};
		//char target = 'z'; // output should be x i.e. letters[0]
		
		char letter = smallestLetter(array, target);
		System.out.println("Result letter: "+letter);
	}
	
	private static char smallestLetter(char[] letters, char target) {
		
		int start = 0;
		int end = letters.length-1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if(target < letters[mid]) {  // must check this at first place bcoz we dont want to change start pos if target is greater
				end = mid - 1;
			} else {
				start = mid +1;
			}
		}
		return letters[start % letters.length];
		//System.out.println("Start: "+start +" | end: "+end);
		/*
		 * if(start == letters.length) { return letters[0]; }
		 */
	}

}
