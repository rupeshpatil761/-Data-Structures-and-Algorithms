package com.dsa.practice.arrays;

public class MinimumSizeSubarray {
	
	// https://leetcode.com/problems/minimum-size-subarray-sum
	
	// https://www.youtube.com/watch?v=xBZfV0OBmLY

	public static void main(String[] args) {
		
		minSubArrayLen(new int[] {2,3,1,2,4,3}, 7);
		minSubArrayLen(new int[] {1,4,4}, 4);
		
	}
	
	private static int minSubArrayLen(int[] nums, int target) {
        int currentSum = 0;
        int n = nums.length;
        int left = 0;
        int ans  = n + 1;

        for (int right = 0 ; right < n; right++) {
        	currentSum = currentSum + nums[right];
            while (currentSum >= target) {
                ans = Math.min(ans, right - left + 1);
                currentSum = currentSum - nums[left++];
            }
        }
        ans = ans == n+1 ? 0 : ans;
        System.out.println("minSubArrayLen result : "+ans);
        return ans;
    }
}
