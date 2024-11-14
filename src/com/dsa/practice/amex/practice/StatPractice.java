package com.dsa.practice.amex.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatPractice {

	public static void main(String[] args) {

		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};

		// convert string numbers array to int array
		int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();   // Converts strings to ints and finally to int[]
        
        System.out.println("Input array is: "+ Arrays.toString(numbers));

        // Calculate and display the statistics
        System.out.println("Mean: " + calculateMean(numbers)); // average of all nos
        System.out.println("Median: " + calculateMedian(numbers)); // middle element
        System.out.println("Mode: " + calculateMode(numbers)); // most occured
        System.out.println("Range: " + calculateRange(numbers)); // max - min
        System.out.println("Nos in Range: "+getNumbersInRange(numbers, 344,6000));
        System.out.println("Nos in Range using boxed: "+getNumbersInRangeUsingBoxed(input, 344,6000));
	}
	
	public static int calculateRange(int[] numbers) {
		int max = Arrays.stream(numbers).max().orElse(0);
		int min =  Arrays.stream(numbers).min().orElse(0);
		return max - min;
	}

	public static long calculateMode(int[] numbers) {
		Map<Integer, Long> map = Arrays.stream(numbers).mapToObj(Integer::valueOf)  // // Converts ints to Integers
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Optional<Map.Entry<Integer, Long>> entry = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst();

		if (entry.isPresent()) {
			return entry.get().getKey();
		} else {
			return -1;
		}
	}

	public static double calculateMedian(int[] numbers) {
    	// sorting is important
		
    	List<Integer> list = Arrays.stream(numbers).mapToObj(Integer::valueOf).sorted().collect(Collectors.toList());
    	
        //Arrays.sort(numbers);  // ***********
        int length = list.size();
        if (length % 2 == 0) {
            return (list.get(length / 2 - 1) + list.get(length / 2)) / 2.0;
        } else {
            return list.get(length / 2);
        }
    }

	// average
	public static double calculateMean(int[] numbers) {
		return Arrays.stream(numbers).average().orElse(0);
	}
	
	public static List<Integer> getNumbersInRange(int[] numbers, int start, int end) {
		return Arrays.stream(numbers).mapToObj(Integer::valueOf).filter(n -> n>=start && n<=end).sorted().collect(Collectors.toList());
	}
	
	public static List<Integer> getNumbersInRangeUsingBoxed(String[] input, int start, int end) {
		return Arrays.stream(input).mapToInt(Integer::parseInt).boxed().filter(n -> n>=start && n<=end).sorted().collect(Collectors.toList());
	}
}
