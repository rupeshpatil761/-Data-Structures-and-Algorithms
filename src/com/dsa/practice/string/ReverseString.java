package com.dsa.practice.string;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println("reverseString : "+ reverseString("Rupesh"));
	}
	
	
	public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

}
