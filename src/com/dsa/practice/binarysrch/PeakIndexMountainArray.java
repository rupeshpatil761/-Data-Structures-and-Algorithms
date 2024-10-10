package com.dsa.practice.binarysrch;

public class PeakIndexMountainArray {
	
	// easy : https://leetcode.com/problems/peak-index-in-a-mountain-array
	//Mediam | https://leetcode.com/problems/find-peak-element 
	
	// ** Solution is same for both problems

	public static void main(String[] args) {
		//int[] arr = {0,10,5,2};  // output should be 1 i.e. 10
		int[] arr = {1,2,3,4,5,6,4,3,2};  // output should be 5 i.e. 6
		int result = peakIndexInMountainArray(arr);
		System.out.println("Result: "+result);
	}
	
	private static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start < end) {  // condition to break loop 
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]) {
            	// you are in dec part of array
                // this may be the ans, but look at left
                // thats why end != mid -1
               end = mid; 
            } else {
            	//you are in asc part of array
                start = mid + 1;// because we know mid+1 ele > mid ele
                
            }
        }
        // in the end start and end both will point to largest number
        return start; // return end;
    }

}
