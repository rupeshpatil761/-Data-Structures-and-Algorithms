package com.dsa.practice.string;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println("Reuslt Approach 1 :"+ validateParenthesis("()[]{}"));
		
		System.out.println("Reuslt Approach 2 :"+ isValidParenthesis("()[]{}"));
	}

	// Approach 1
	private static boolean validateParenthesis(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(char ch : str.toCharArray()) {
			if(ch=='(' || ch=='[' || ch=='{') {
				stack.push(ch);
			} else {
				if(stack.isEmpty()) {
					return false; 
				}
				// peek element from stack and compare with opening and closing brackets
				char top = stack.peek();
				if(top=='(' && ch==')' || top=='[' && ch==']' || top=='{' && ch=='}') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		// If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
		return stack.isEmpty();
	}
	
	// Approach 2
	private static boolean isValidParenthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
/*

Example 1:

Input: s = "()[]{}"

Output: true

Example 2:

Input: s = "(]"

Output: false

Example 3:

Input: s = "([])"

Output: true

*/