package data_structures.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// array 1 = [0,3,4,31]
		// array 2 = [4,6,30]
		// merged [0,3,4,4,6,30,31]
		
		//Both arrays must be sorted

		int[] array1 = { 0, 3, 4, 31 };
		int[] array2 = { 4, 6, 30, 32};

		mergeArraysSolution1(array1, array2);
	}
	
	private static int[] mergeArraysSolution2(int[] array1, int[] array2) {

		int array1Length = array1.length;
		int array2Length = array2.length;

		if (array1Length == 0) {
			return array2;
		}
		
		if (array2Length == 0) {
			return array1;
		}

		int[] resultArray = new int[(array1.length + array2.length)];

		int i = 0, j = 0;
		
		for (int k=0; k < resultArray.length; k++) {
			/**
			 * two avoid index out of bounds exceptions on both arrays, we need to put additional conditions 
			 */
			if (i != array1.length && ( j == array2.length || array1[i] <= array2[j])) {
				resultArray[k] = array1[i++];
			} else {
				resultArray[k] = array2[j++];
			}
		}
		
		System.out.println(Arrays.toString(resultArray));
		
		return resultArray;
	}

	// time complexity becomes O(array1Length + array2Length)
	private static int[] mergeArraysSolution1(int[] array1, int[] array2) {

		int array1Length = array1.length;
		int array2Length = array2.length;

		if (array1Length == 0) {
			return array2;
		}
		
		if (array2Length == 0) {
			return array1;
		}

		int[] resultArray = new int[(array1.length + array2.length)];

		int i = 0, j = 0, k = 0;
		
		// checking elements of both array and adding the least element first in the merged array
		// Using ++ operators in statement itself instead writing on next line
		while (i < array1Length && j < array2Length) {
			if (array1[i] <= array2[j]) {
				resultArray[k++] = array1[i++];
			} else {
				resultArray[k++] = array2[j++];
			}
		}
		
		// we need put remaining elements from array 1
		while (i < array1Length) {
			resultArray[k++] = array1[i++];
		}
		
		// we need put remaining elements from array 2
		while (j < array2Length) {
			resultArray[k++] = array2[j++];
		}

		System.out.println(Arrays.toString(resultArray));
		
		return resultArray;
	}

	private static void failedSolution(int[] array1, int[] array2) {
		int array1Length = array1.length;
		int array2Length = array2.length;

		if (array1Length < 1 || array2Length < 1) {
			throw new RuntimeException("Arrays length(s) less than 1");
		}

		int[] resultArray = new int[(array1.length + array2.length)];
		int k = 0;
		
		
		/**
		 * This solution failed because it will always iterate for array 1 elements. 
		 * And it will always compare the 1st element from array 1 with every element of array 2 
		 * So it will never put same elements in result array i.e. 4 & 4
		 */
		
		/**
		 * Challenge for me was, I was just thinking of using for loop but all problems can't be solve using for loop.
		 */
		for (int i = 0; i < array1Length; i++) {
			for (int j = 0; j < array2Length; j++) {
				if (array1[i] <= array2[j]) {
					resultArray[k] = array1[i];
				} else {
					resultArray[k] = array2[j];
				}
			}
			k++;
		}
		System.out.println(Arrays.toString(resultArray));
	}

}
