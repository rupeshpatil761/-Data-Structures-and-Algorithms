package com.dsa.practice.string;

public class StringRotation {

	public static void main(String[] args) {
		
		String s = "abcde"; String goal = "cdeab"; // output is true
		boolean result = rotateString(s, goal);
		
		System.out.println("Result 1: "+result);
		
		s = "abcde"; goal = "abced"; // output is true
		result = rotateString(s, goal);
		
		System.out.println("Result 2: "+result);
		
	}
	
	 public static boolean rotateString(String s, String goal) {
	        if(s==null || goal==null){
	            return false;
	        }

	        if(s.length() != goal.length()) {
	            return false;
	        }

	        String combinedString = s + s;

	        if(combinedString.contains(goal)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

}
