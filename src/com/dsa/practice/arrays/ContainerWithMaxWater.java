package com.dsa.practice.arrays;

public class ContainerWithMaxWater {
	
	// Medium - https://leetcode.com/problems/container-with-most-water/
	
	// https://www.youtube.com/watch?v=w7ftYsZtIbs

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right -left);
            maxArea = Math.max(currentArea, maxArea);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Result maxArea : "+maxArea);
	}
}
