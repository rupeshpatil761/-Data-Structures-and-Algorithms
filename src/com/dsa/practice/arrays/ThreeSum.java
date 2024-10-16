package com.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	// time complexity will be o(n2)
	// space complexity: o(1)
	// This one of the problem where we get solution using n2 as best time complexity
	public static void main(String[] args) {
		int[] array = {-1,0,1,2,-1,-4};
		
		if (array == null || array.length < 3) return ;//new ArrayList<>();
		
		// ****** Sort the elements
	    Arrays.sort(array);
		
		Set<List<Integer>> resultSet = new HashSet<>(); 
		
		for (int i=0; i<array.length-2;i++) {
			// 1st number: i will be fixed
			int left = i+1;
			
			int right = array.length-1;
			
			while (left < right) {
				int sum = array[i] + array[left] + array[right]; 
				if(sum == 0) {
					resultSet.add(Arrays.asList(array[i] , array[left] , array[right]));
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println("Result set: "+new ArrayList<>(resultSet));
	}
}
