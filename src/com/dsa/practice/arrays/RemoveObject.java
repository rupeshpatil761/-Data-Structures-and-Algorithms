package com.dsa.practice.arrays;

import java.util.Arrays;

public class RemoveObject {

	public static void main(String[] args) {
	
		//int[] nums = {1,2,3,4,2,5};	int val =2;
		//int[] nums = {3,2,2,3}; int val = 3;
		/**Output: 2, nums = [2,2,_,_]
		Explanation: Your function should return k = 2, with the first two elements of nums being 2.
		It does not matter what you leave beyond the returned k (hence they are underscores).**/
		
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		
		int result = apprach1(nums, val);
		System.out.println("Result: "+result);
	}

	private static int apprach1(int[] nums, int val) {
		int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println("nums: "+Arrays.toString(nums));
        return index;
	}

}
