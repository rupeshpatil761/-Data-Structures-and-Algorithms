package com.dsa.practice.string;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// https://leetcode.com/problems/decode-string/description/
		System.out.println("Result is: "+decodeString("3[a]2[bc]")); // aaabcbc
		System.out.println("Result is: "+decodeString("3[a2[c]]")); // accaccacc
		System.out.println("Result is: "+decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
		System.out.println("Result is: "+decodeString("2[a3[c2[x]]y]")); //acxxcxxcxxyacxxcxxcxxy
		System.out.println("Result is: "+decodeString("10[leetcode]")); // leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode
		System.out.println("Result is: "+decodeString("11[ab2[c]de]")); // abccdeabccdeabccdeabccdeabccdeabccdeabccdeabccdeabccdeabccdeabccde
		
	}
	
	// Time Complexity: O(n)
	// Space Complexity: O(n + m)
	private static String decodeString(String str) {
		
		Stack<Integer> numStack = new Stack();
		Stack<String> stringStack = new Stack();
		int k = 0;
		for(char c : str.toCharArray()) {
			
			// digit, [ , ] and char
			
			if(Character.isDigit(c)) {
				k = (k * 10) + (c - '0');
				continue;
			}
			
			if(c == '[') {
				numStack.push(k);
				k = 0;
				stringStack.push(String.valueOf(c));
				continue;
			}
			
			// char case
			if(c != ']') {
				stringStack.push(String.valueOf(c));
				continue;
			}
			
			// ] case
			StringBuilder tempString = new StringBuilder();
			while(!stringStack.peek().equals("[")) {
				tempString.insert(0,stringStack.pop());
			}
			// also remove [
			stringStack.pop();
			
			StringBuilder replacementString = new StringBuilder();
			int count = numStack.pop();
			while(count!=0) {
				replacementString.append(tempString);
				count--;
			}
			// add to stack
			stringStack.push(replacementString.toString());
		}
		
		// final result
		StringBuilder result = new StringBuilder();
		while(!stringStack.isEmpty()) {
			result.insert(0, stringStack.pop());
		}
		return result.toString();
	}
	
	// https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/DecodeString.java
	public static String decodeStringGithub(String s) {

	    Stack<Integer> numStack = new Stack<>();
	    Stack<String> stringStack = new Stack<>();
	    int k = 0;

	    for (char c : s.toCharArray()) {

	      if (Character.isDigit(c)) {
	        k = (k * 10) + (c - '0');
	        continue;
	      }

	      if (c == '[') {
	        numStack.push(k);
	        k = 0;
	        stringStack.push(String.valueOf(c));
	        continue;
	      }

	      if (c != ']') {
	        stringStack.push(String.valueOf(c));
	        continue;
	      }

	      StringBuilder temp = new StringBuilder();
	      while (!stringStack.peek().equals("["))
	        temp.insert(0, stringStack.pop());

	      // remove the "["
	      stringStack.pop();

	      // Get the new string
	      StringBuilder replacement = new StringBuilder();
	      int count = numStack.pop();
	      for (int i = 0; i < count; i++)
	        replacement.append(temp);

	      // Add it to the stack
	      stringStack.push(replacement.toString());
	    }

	    StringBuilder result = new StringBuilder();
	    while (!stringStack.empty()) {
	      result.insert(0, stringStack.pop());
	    }
	    return result.toString();
	  }
}
