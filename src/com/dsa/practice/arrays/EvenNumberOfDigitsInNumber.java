package com.dsa.practice.arrays;

public class EvenNumberOfDigitsInNumber {

	public static void main(String[] args) {
		int[] array = {12,2,345,6,7896};
		// ouput should be 2 i.e. 12 and 7896 because these contains even number of digits
		
		int count = 0;
		for (int number : array) {
			if(isEvenDigits(number)) {
				count++;
			}
		}
		System.out.println("Event digits number present are : "+count);
	}
	
	private static boolean isEvenDigits(int num) {
		int n = 0;
		if(num < 0) {
			num = num  * -1;
		}
		if(num ==0) {
			return false;
		}
		while (num > 0) {
			n++;
			num = num / 10;
		}
		return n % 2 ==0; 
	}

}
