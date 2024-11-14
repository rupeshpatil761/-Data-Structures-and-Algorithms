package com.dsa.practice.gsrrp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoopDetection {

	//Efficiency: The algorithm runs in O(n) time complexity with O(1) additional space.
	// time complexity is  ;; O(n).
	// space complexity is  ;;The function uses a few extra integer variables for pointers (tortoise, hare) and the cycleLength. 
	//These require a constant amount of space, i.e. O(1).

    public static int findLoopLength(int[] array, int startIndex) {
        // Step 1: Detect if there's a loop using Floyd's Cycle Detection Algorithm
        int tortise = startIndex;
        int hare = startIndex;
        
        List<Integer> cycyleList = new ArrayList<>();

        // Phase 1: moving pointers to Finding intersection point 
        do {
            tortise = array[tortise];
            hare = array[array[hare]];
            
            // Make sure we don’t go out of bounds
            if(hare < 0 || hare >= array.length || array[hare] < 0 || array[hare] > array.length) {
              return -1; // no cycle
            }
            
            cycyleList.add(tortise);
            
        } while (tortise != hare);
        
        //System.out.println("after first do-while -- tortise: "+tortise + " and hare: "+hare);

        // Phase 2: Determine the length of the loop
        int cycleCount = 0;
        do {
        	tortise = array[tortise];
            cycleCount++;
        } while (tortise != hare);

        System.out.println("cycyleString: "+cycyleList.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(" -> ")));
        return cycleCount > 0 ? cycleCount : -1;
    }
    
    /**
     *  Detect if there is a cycle using the Hare and Tortoise method.
		Find the starting point of the cycle.
		Determine the length of the cycle.
     */
    
    public static void main(String[] args) {
        // Sample input
        int startIndex = 0;
        System.out.println("Input 1 o/p: "+findLoopLength(new int[]{1, 2, 3, 4, 2}, startIndex)); // This has a loop: 2 -> 3 -> 4 -> 2
        
        seperator();
        
        System.out.println("Input 2 o/p: "+findLoopLength(new int[]{0}, startIndex));
        
        seperator();

        System.out.println("Input 3 o/p: "+findLoopLength(new int[]{1, 0}, startIndex));
        
        seperator();
        
        System.out.println("Input 4 o/p: "+findLoopLength(new int[]{1, 2, 0}, startIndex));
        
        seperator();
        
        System.out.println("Input 5 o/p: "+findLoopLength(new int[]{1, 2, -1}, startIndex));
        
        seperator();
        
        System.out.println("Input 6 o/p: "+findLoopLength(new int[]{1, 2, 3, 4, 5 ,6, 0}, startIndex));
        
        seperator();
        
        System.out.println("Input 7 o/p: "+findLoopLength(new int[]{1, 2, 3, 4, 5 ,6, 2}, startIndex));
        
        seperator();
        
        System.out.println("Input 8 o/p: "+findLoopLength(new int[]{1, 2, -1, -1}, startIndex));
    }
	
	private static void seperator() {
		System.out.println("----------------------------------------------");
	}

}
