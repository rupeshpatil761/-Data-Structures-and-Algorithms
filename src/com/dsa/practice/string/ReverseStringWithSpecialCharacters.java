package com.dsa.practice.string;

import java.util.Stack;

public class ReverseStringWithSpecialCharacters {
	
	//Stacks operate on a Last-In-First-Out (LIFO) principle, so this effectively reverses the order of letters.
	
	 public static String reverseString(String s) {
	        // Step 1: Use a stack to reverse the alphabetic characters
	        Stack<Character> lettersStack = new Stack<>();
	        
	        // Push all letters onto the stack
	        for (char ch : s.toCharArray()) {
	            if (Character.isLetter(ch)) {
	                lettersStack.push(ch);
	            }
	        }
	        
	        System.out.println("lettersStack: " + lettersStack);
	        
	        // Step 2: Build the result string by popping letters from the stack
	        StringBuilder result = new StringBuilder();
	        for (char ch : s.toCharArray()) {
	            if (Character.isLetter(ch)) {
	                result.append(lettersStack.pop()); // *******
	            } else {
	                result.append(ch);
	            }
	        }
	        
	        return result.toString();
	    }

	    public static void main(String[] args) {
	        //String input = "a-bC-dEf-ghIj";
	        String input = "Swa$pn&il";
	        String output = reverseString(input);
	        System.out.println("Original string: " + input);
	        System.out.println("Reversed string: " + output);
	    }
}
