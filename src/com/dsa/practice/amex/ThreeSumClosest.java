package com.dsa.practice.amex;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
	    int target = 1;
	    int result = solution(nums, target);
	    System.out.println("Result: "+result);
	}

	// Time complexity - O(n2)  -- this is best for this problem
	// space complexity will be O(1).
	private static int solution(int[] arr, int target) {
		// Sort the elements
	    Arrays.sort(arr);
	    int resultSum = arr[0] + arr[1] + arr[2];
	    int minDifference = Integer.MAX_VALUE;

	    // Now fix the first element and find the other two elements
	    for (int i = 0; i < arr.length - 2; i++) {
	      // Find other two elements using Two Sum approach
	      int left = i + 1;
	      int right = arr.length - 1;

	      while (left < right) {
	        int sum = arr[i] + arr[left] + arr[right];

	        if (sum == target) {
	          return target;
	        } else if (sum < target) {
	          left++;
	        }else {
	          right--;
	        }

	        int diffToTarget = Math.abs(sum - target);
	        if (diffToTarget < minDifference) {
	          // update the result sum
	          resultSum = sum;
	          minDifference = diffToTarget;
	        }
	      }
	    }
	    return resultSum;
	}

}
