package com.dsa.practice.amex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceNumber {

	
	// https://leetcode.com/problems/longest-consecutive-sequence/description/
	public static void main(String[] args) {

		int[] array = { 0,3,7,2,5,8,4,6,0,1 };

		// output should be 4 i.e. 1,2,3,4

		System.out.println("Max Count using solutionBySortingArray: " + solutionBySortingArray(array));
		System.out.println("Max Count using bestSolution: " + bestSolution(array));
	}
	
	// time complexity O(n log n)
	public static int solutionBySortingArray(int[] nums) {
		if (nums.length == 0) return 0;
		int n = nums.length;
		Arrays.sort(nums);
		int currentLength =1;
		int maxLength = 1;
		// iterate array
		for (int i=1; i<n; i++) {
			int currentNo = nums[i];
			int prevNo = nums[i-1];
			if(currentNo == (prevNo+1)) {
				currentLength++;
			} else {
				currentLength = 1;
			}
			maxLength = Math.max(maxLength, currentLength);
		}
		return maxLength;
	}

	public static int longestConsecutiveSolution2(int[] nums) {
		
		int max = 0;

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			int count = 1;

			// look left
			int num = nums[i];
			while (set.contains(--num)) {
				count++;
				set.remove(num);
			}

			// look right
			num = nums[i];
			while (set.contains(++num)) {
				count++;
				set.remove(num);
			}

			max = Math.max(max, count);
		}

		return max;
	}
	
	// https://www.youtube.com/watch?v=P6RZZMu_maU
	// Time Complexity: O(n), where n is the number of elements in nums. 
	// Because Each element is processed in constant time due to the HashSet.
	// Space Complexity: O(n) for storing the elements in the HashSet.
	public static int bestSolution(int[] nums) {
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			int num = nums[i];
			// check if previous no present in set or not
			// if not means current number could be the start of a new consecutive sequence.
			// If it’s the start of a sequence, you enter a loop where you increment a count
			if(!set.contains(num-1)) {
				while(set.contains(num + count)) {
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

}
