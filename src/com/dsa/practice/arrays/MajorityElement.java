package com.dsa.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		int result = hashMapApproach(new int[]{2,2,1,1,1,2,2});
		System.out.println("Result using hasmap: "+result);
		result = majorityElement(new int[]{2,2,1,1,1,2,2});
		System.out.println("Result using moore algo: "+result);
	}
	
	private static int hashMapApproach(int[] nums) {
		int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        n = n / 2; // ***************identify the element that occurs more than n/2 times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
	}
	// Approach 3: Moore Voting Algorithm
	//The intuition behind the Moore's Voting Algorithm is based on the fact that 
	//if there is a majority element in an array, 
	//it will always remain in the lead, even after encountering other elements.
	public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }

}
