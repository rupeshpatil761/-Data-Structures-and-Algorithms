package com.dsa.practice.gsrrp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintPairSum {
	
	// brute force approach
	//Time Complexity: O(n2) — The nested loops result in checking every pair of elements.
	// Space Complexity: O(1) — No extra space is required beyond a few variables for iteration and comparison.  
	
	public static void findPairsWithSumBruteForce(int[] arr, int k) {
        int n = arr.length;
        // Iterate through all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }
	
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5, 6};
        int k = 7;

        System.out.println("Input array: "+Arrays.toString(arr));
        
        System.out.println("Brute force approach : Pairs with sum " + k + ":");
        findPairsWithSumBruteForce(arr, k);
        
        System.out.println("-------------------------");
        System.out.println("HashSet approach : Pairs with sum " + k + ":");
        findPairsWithSum(arr, k);
    }
	
	//Hash Map Approach:
	// Time Complexity: O(n) — We iterate through the array once and perform constant time operations for each element.
	// Space Complexity: O(n) — We use additional space for the hash sets 
	public static void findPairsWithSum(int[] arr, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> pairs = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;
            if (seen.contains(complement)) {
                String pair = Math.min(num, complement) + "," + Math.max(num, complement);
                if (!pairs.contains(pair)) { // to have unique pairs
                    pairs.add(pair);
                    System.out.println("(" + num + ", " + complement + ")");
                }
            }
            seen.add(num);
        }
    }
}
