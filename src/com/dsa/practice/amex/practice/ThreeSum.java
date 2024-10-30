package com.dsa.practice.amex.practice;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };

		// Output: [[-1,-1,2],[-1,0,1]]

		Arrays.sort(nums);

		Set<List<Integer>> resultSet = new HashSet<>();

		for (int i = 0; i < nums.length - 2; i++) {
			// i is fixed
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		System.out.println("resultSet: " + resultSet);
	}
}
