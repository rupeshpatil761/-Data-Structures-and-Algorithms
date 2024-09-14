package com.dsa.practice.string;

public class StringToIntegerAtoi {

	public static void main(String[] args) {
		
		System.out.println("Result for input 42: "+convertStringToInt("42"));
		
		System.out.println("Result for input -042: "+convertStringToInt(" -042"));
		
		System.out.println("Result for input 1337c0d3: "+convertStringToInt("1337c0d3"));
		
		System.out.println("Result for input 0-1: "+convertStringToInt("0-1"));
		
		System.out.println("Result for input words and 987: "+convertStringToInt("words and 987"));
		
		System.out.println("Result for input -91283472332: "+convertStringToInt("-91283472332"));
		System.out.println("myAtoi - Result for input -91283472332: "+myAtoi("-91283472332"));
	}

	// Time Complexity: O(n), where n is the length of the input string.
	// Space Complexity: O(1), as the space used by the function does not scale with the size of the input.
	private static int convertStringToInt(String str) {
		str = str.trim();

		if (str.length() == 0) {
			return 0;
		}
		int i = 0;
		int ans = 0;
		boolean isNegative = false;
		// handle first negative number
		char firstChar = str.charAt(0);
		if (i == 0) {
			if (firstChar == '-') {
				isNegative = true;
				i++;
			} else if (firstChar == '+') {
				i++;
			}
		}

		while (i < str.length()) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9') {
				break;
			}

			int digit = ch - '0';
			ans = ans * 10 + digit;

			// handle MIN and MAX numbers
			if (isNegative) {
				if (-ans < (Integer.MIN_VALUE + digit) / 10) {
	                return Integer.MIN_VALUE; // Underflow
	            }
	        } else {
	            if (ans > (Integer.MAX_VALUE - digit) / 10) {
	                return Integer.MAX_VALUE; // Overflow
	            }
	        }
			i++;
		}

		// handle negative answers
		if (isNegative) {
			ans = -ans;
		}
		return (int) ans;
	}
	
	public static int myAtoi(String s) {
        // Check for empty spaces
        s = s.trim();
        if(s.length()==0) return 0;
        // check for the sign
        int sign = 1;
        int i = 0;
        char c = s.charAt(0);
        if (c == '-') {
            sign = -1;
            i++;  
        } else if (c == '+') {
            i++; 
        }
        long sum = 0;
        while (i < s.length()) {
            char currChar = s.charAt(i);
            // check for non integer characters
            if (currChar < '0' || currChar > '9') break;
            // check for integer characters
            int a = currChar - '0';
            // formulate the answer
            sum = sum * 10 + a;
            // check for the overflow condition
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        // return the answer with the sign
        return (int) (sign * sum);
    }

}
