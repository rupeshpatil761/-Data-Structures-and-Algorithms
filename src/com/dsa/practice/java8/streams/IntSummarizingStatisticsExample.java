package com.dsa.practice.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class IntSummarizingStatisticsExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,4,5,7,3,6,8,9);
		
		IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
		
		System.out.println("Average: "+stats.getAverage());
		System.out.println("Count: "+stats.getCount());
		System.out.println("Max: "+stats.getMax());
		System.out.println("Min: "+stats.getMin());
		System.out.println("Sum: "+stats.getSum());
		
	}

}
