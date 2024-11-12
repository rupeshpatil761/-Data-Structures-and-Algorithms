package com.dsa.practice.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		//int[] nums = {1,1,2}; //{0,0,1,1,1,2,2,3,3,4};
		int[] nums = {0,0,1,1,1,2,2,3,3,4}; // this should be sorted
		int result = removeDuplicatesUsingTwoPointers(nums);
		System.out.println("Result: "+result);
		
		System.out.println("Result using  removeDuplicates: "+removeDuplicates(nums));
		
	}
	
	public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length;i++) {
            set.add(nums[i]);
        }

        int index = 0;
        for(int i=0; i<nums.length;i++) {
            if(set.contains(nums[i])) {
                nums[index++] = nums[i];
                set.remove(nums[i]);
            }
        }
        System.out.println("Nums: "+Arrays.toString(nums));
        return index;
    }
	
	public static int removeDuplicatesUsingTwoPointers(int[] nums) {
		System.out.println("removeDuplicatesUsingTwoPointers inside");
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println("Nums: "+Arrays.toString(nums));
        return index;
    }

}
