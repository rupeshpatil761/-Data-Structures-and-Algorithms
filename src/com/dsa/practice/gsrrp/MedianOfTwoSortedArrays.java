package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

	// In simpler terms, you need to find the middle value of the combined, sorted array formed by merging nums1 and nums2
	
	// if merged array has even numbers -- return the average of two middle numbers
	// if merged array has odd numbers -- return the middle number itself
	
	public static void main(String[] args) {
		//Input: nums1 = [1,3], nums2 = [2]
		//Output: 2.00000
		
		//int[] arr1 = {1,3};
		//int[] arr2 = {2};  // 2.0
		
		int[] arr1 = {1,2};
		int[] arr2 = {3,4};  // 2.5
		
		double result = bruteForceSolution(arr1, arr2);
		
		System.out.println("Result using brute force apprach: "+result);
		
		System.out.println("------------------------------------------");
		
		result = mergeSortApproach(arr1, arr2);
		
		System.out.println("Result using Median till mid of arrays apprach: "+result);
	}
	
	
	//Time complexity:  O (n + m)
	// space complexity: O( N + M / 2)
	private static double mergeSortApproach(int[] arr1, int[] arr2) {
		int total = arr1.length + arr2.length;
		int mid = total / 2;
		int[] mergedArrayTillMid = mergedArray(arr1, arr2, mid);
		
		if(total%2==0) {
			return (double) (mergedArrayTillMid[mid] + mergedArrayTillMid[mid-1]) / 2.0;
		} else {
			return (double) mergedArrayTillMid[mid];
		}
	}
	
	// merge the both arrays till middle element only
	private static int[] mergedArray(int[] arr1, int[] arr2, int mid) {
		if(arr1.length == 0) return arr2;
		if(arr2.length == 0) return arr1;
		int[] mergedArray = new int[mid+1];
		int i=0;
		int j=0;
		int k=0;
		while(i < arr1.length && j < arr2.length && k <= mid) {
			if(arr1[i] < arr2[j]) {
				mergedArray[k++] = arr1[i++];
			} else {
				mergedArray[k++] = arr2[j++];
			}
		}
		while(i < arr1.length && k <= mid) {
			mergedArray[k++] = arr1[i++];
		}
		while(j < arr2.length && k <= mid) {
			mergedArray[k++] = arr2[j++];
		}
		return mergedArray;
	}


	//Time complexity:  O ((n + m) ) OR O(n+m) * log (m + n))
	// space complexity: O(n+m)
	private static double bruteForceSolution(int[] arr1, int[] arr2) {
		// merge both sorted arrays
		// sort merged array
		// check if merged array has even or odd length
		// if odd return middle number
		// else return average of two middle numbers
		
		double median = 0.0;
		
		int[] mergedArray = new int[arr1.length + arr2.length];
		
		int k = 0;
		
		for(int i=0; i<arr1.length; i++) {
			mergedArray[k++] = arr1[i];
		}
		
		for(int i=0; i<arr2.length; i++) {
			mergedArray[k++] = arr2[i];
		}
		
		// sort merged array -- Not required always based on input we can remove this
		Arrays.sort(mergedArray);
		
		
		int n = mergedArray.length;
		if(mergedArray.length % 2 == 0) {
			int mid1 = mergedArray[n/2];
			int mid2 = mergedArray[(n/2) -1];
			median = (mid1 + mid2) / 2.0;
		} else {
			median = mergedArray[n/2];
		}
		return median;
	}

}
