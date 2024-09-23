package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class RainWaterTrapping {
	
	// https://www.youtube.com/watch?v=UZG3-vZlFM4&t=206s
	
	public static void main(String[] args) {
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // output should be 6
		int[] height = {4,2,0,3,2,5}; // output should be 9
		int ans = solution(height);
		System.out.println("Result: "+ans);
	}

	// time complexity = o(n) -- Overall, each major step 
	   // (creating leftArray, rightArray, and calculating the result) takes linear time. 
       // Therefore, the total time complexity of the method is: o(n)
	// space complexity = o(n)
	private static int solution(int[] height) {
		int n = height.length;
		// pre-process original array to create auxiliary arrays
		// to find if there are any big builds on left side
		int[] leftArray = new int[height.length];
		leftArray[0] = height[0];
		for(int i = 1; i< n; i++) {
			leftArray[i] = Math.max(leftArray[i-1], height[i]);
		}
		
		// to find if there are any big builds on right side
		int[] rightArray = new int[height.length];
		rightArray[n-1] = height[n-1];
		for(int j=n-2; j>=0 ; j--) {
			rightArray[j] = Math.max(rightArray[j+1], height[j]); 
		}
		
		int ans = 0;
		for (int i=0; i<n; i++) {
			// find minimum of both left and right array and subtract height of building from it.
			ans += Math.min(leftArray[i], rightArray[i]) - height[i];
		}
		return ans;
	}
	

}
