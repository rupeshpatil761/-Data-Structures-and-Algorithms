package com.dsa.practice.arrays;

public class LengthOfConsecutiveOnes {
	
	//https://www.youtube.com/watch?v=uqoSvsxDB04
	
	/**
	 * For example:
	 * n = 101
	 * its binary representation: 0 1 1 0 0 1 0 1
	 * length = 2 (1st and 2nd element in above) 
	 * output = 2 
	 */

	public static void main(String[] args) {
		//int n = 110;
		int n = 101;
		//int n = 73;
		//int n = 64;
		boolean result = isConsecutive(n);
		System.out.println("Are there consecutive 1's in given numbers i.e. "+n+" on its binary representation: "+result);
		
		findConsecutiveOnes(n);
	}
	
	private static boolean isConsecutive(int n) {
		if((n & n<<1) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// O(log N) -- complexity
	private static void findConsecutiveOnes(int n) {
		int count = 0;
		while(n > 0) {
			System.out.println("====n: "+n);
			n = (n & (n<<1));
			count++;
		}
		System.out.println("====consecutive 1's count: "+count);
	}
	
	/**
	 * n<<1 --- left shift n by 1
	 * The symbol & denotes the bitwise AND operator. It evaluates the binary value of given numbers
	 *  Let's break it down.

		The binary value of 10 is 1010
		
		The binary value of 12 is 1100
		
		Here is something you should have in mind before we start the operation:
		
		1 and 0 => 0
		0 and 1 => 0
		1 and 1 => 1
		0 and 0 => 0
		So let's carry out the operation.
		
		The first character for 10 is 1 and the first character for 12 is also 1 so:
		
		1 and 1 = 1.
		
		We move on to the second characters – 0 for 10 and 1 for 12:
		
		1 and 0 = 0.
		
		For the third characters – 1 for 10 and 0 for 12:
		
		1 and 0 = 0.
		
		For the fourth characters – 0 for 10 and 0 for 12:
		
		0 and 0 = 0.
		
		Now let's combine all the returned characters. We would have 1000.
		
		The binary value 1000 in base 10 is 8 and that is why our operation returned 8.
	 */
}
