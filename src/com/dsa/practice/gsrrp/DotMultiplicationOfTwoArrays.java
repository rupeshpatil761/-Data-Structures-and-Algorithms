package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class DotMultiplicationOfTwoArrays {

	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5}; // Different length // Outputs: 14 (1*4 + 2*5)
		
		System.out.println("Input Array 1: "+Arrays.toString(array1));
		System.out.println("Input Array 2: "+Arrays.toString(array2));
		
		// Check if both arrays have the same length
        if (array1.length == array2.length) {
        	System.out.println("Dot multiplication is -1");
            return;
        }

        // Calculate the dot product for arrays of different lengths
        int dotProductResult = 0;
        int minLength = Math.min(array1.length, array2.length);

        for (int i = 0; i < minLength; i++) {
            dotProductResult += array1[i] * array2[i];
        }
        System.out.println("Dot multiplication is : "+dotProductResult);
	}

}
