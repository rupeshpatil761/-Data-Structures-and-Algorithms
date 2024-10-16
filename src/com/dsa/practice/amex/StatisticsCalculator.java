package com.dsa.practice.amex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticsCalculator {
	
    public static void main(String[] args) {
    	String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};

        // Convert string input to integer array
        int[] numbers = Arrays.stream(input)
                              .mapToInt(Integer::parseInt)
                              .toArray();
        
        System.out.println("Input array is: "+ Arrays.toString(numbers));

        // Calculate and display the statistics
        System.out.println("Mean: " + calculateMean(numbers));
        System.out.println("Median: " + calculateMedian(numbers));
        System.out.println("Mode: " + calculateModeNew(numbers));
        System.out.println("Range: " + calculateRange(numbers));
    }

    // average of all numbers
    public static double calculateMean(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0.0);
    }

    // middle number
    public static double calculateMedian(int[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;
        if (length % 2 == 0) {
            return (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            return numbers[length / 2];
        }
    }
    
    // most repeated no 
    public static int calculateModeNew(int[] numbers) {
 		Map<Integer, Long> occuranceMap = Arrays.stream(numbers).mapToObj(Integer::valueOf)
 				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 		
 		Optional<Map.Entry<Integer, Long>> modeElement = occuranceMap.entrySet().stream()
 				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst();
 		
 		if(modeElement.isPresent() && modeElement.get().getValue() > 1) {
 			//System.out.println("Mode is : "+modeElement.get());
 			return modeElement.get().getKey();
 		} else {
 			//System.out.println("No Mode");
 			return -1;
 		}
 	}
    
    // largest no - smallest no  = range
    public static int calculateRange(int[] numbers) {
        int min = Arrays.stream(numbers).min().orElse(0);
        int max = Arrays.stream(numbers).max().orElse(0);
        return max - min;
    }

    private static String calculateMode(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        StringBuilder modes = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                modes.setLength(0); // Reset modes if a new max is found
                modes.append(entry.getKey());
            } else if (entry.getValue() == maxFrequency) {
                modes.append(", ").append(entry.getKey());
            }
        }

        return (maxFrequency > 1) ? modes.toString() : "No mode";
    }
}
