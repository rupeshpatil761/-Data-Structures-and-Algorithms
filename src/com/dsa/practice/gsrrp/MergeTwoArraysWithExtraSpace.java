package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class MergeTwoArraysWithExtraSpace {
	
	/**
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(m+n)
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int[] mergeSortedArraysAscending(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArray = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Traverse both arrays
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        
        System.out.println("mergedArray : "+Arrays.toString(mergedArray));

        // Append remaining elements from arr1, if any
        while (i < m) {
            mergedArray[k++] = arr1[i++];
        }

        // Append remaining elements from arr2, if any
        while (j < n) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        
        System.out.println("Array 1: "+Arrays.toString(arr1));
        System.out.println("Array 2: "+Arrays.toString(arr2));

        int[] mergedArray = mergeSortedArraysAscending(arr1, arr2);

        System.out.println("Merged Array Ascending:: "+Arrays.toString(mergedArray));
        
        System.out.println("-------------------------------");
        
        mergedArray = mergeSortedArraysDescending(arr1, arr2);
        
        System.out.println("Merged Array Descending:: "+Arrays.toString(mergedArray));
    }
    
    public static int[] mergeSortedArraysDescending(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArray = new int[m + n];

        int i = m - 1;  // Start from the end of arr1
        int j = n - 1;  // Start from the end of arr2
        int k = 0;      // Start from the beginning of mergedArray

        // Traverse both arrays from end to start
        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                mergedArray[k++] = arr1[i--];
            } else {
                mergedArray[k++] = arr2[j--];
            }
        }

        // Append remaining elements from arr1, if any
        while (i >= 0) {
            mergedArray[k++] = arr1[i--];
        }

        // Append remaining elements from arr2, if any
        while (j >= 0) {
            mergedArray[k++] = arr2[j--];
        }

        return mergedArray;
    }

}
