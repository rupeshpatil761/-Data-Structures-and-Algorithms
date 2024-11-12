package com.dsa.practice.arrays;

public class MinimumSizeSubarray {
	
	// https://leetcode.com/problems/minimum-size-subarray-sum
	
	// https://www.youtube.com/watch?v=xBZfV0OBmLY

	public static void main(String[] args) {
		
		minSubArrayLen(new int[] {2,3,1,2,4,3}, 7);
		minSubArrayLen(new int[] {1,4,4}, 4);
		
	}
	
	// sliding window approach
	private static int minSubArrayLen(int[] nums, int target) {
        int currentSum = 0;
        int n = nums.length;
        int left = 0;
        int ans  = n + 1;

        for (int right = 0 ; right < n; right++) {
        	currentSum = currentSum + nums[right];
            while (currentSum >= target) {
                ans = Math.min(ans, right - left + 1); // length of subarray
                currentSum = currentSum - nums[left++]; // update the window
            }
        }
        ans = ans == n+1 ? 0 : ans;
        System.out.println("minSubArrayLen result : "+ans);
        return ans;
    }
}

/*
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.


Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1


Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
*/
