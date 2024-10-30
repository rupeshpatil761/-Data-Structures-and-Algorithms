package com.dsa.practice.amex.practice;

import java.util.*;

public class LongestConsSequence {

	public static void main(String[] args) {

		int[] nums = {0,3,7,2,5,8,4,6,0,1 };
		// Output: 9

		Set<Integer> uniqueElementsSet = new HashSet<>();

		for (int num : nums) {
			uniqueElementsSet.add(num);
		}

		int maxCount = 0;

		for (int num : nums) {

			int count = 0;

			if (!uniqueElementsSet.contains(num - 1)) { // means its start number

				while (uniqueElementsSet.contains(num + count)) {
					count++;
				}

				maxCount = Math.max(maxCount, count);
			}
		}
		
		System.out.println("Result: "+maxCount);
	}
}
