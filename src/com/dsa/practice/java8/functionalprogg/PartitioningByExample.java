package com.dsa.practice.java8.functionalprogg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByExample {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,4,5,7,3,6,8,9);
		
		Map<Boolean, List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(n -> n%2==0));
		
		System.out.println("map: "+map);
		
		// Another example could be
		// Bank VIP and Regular customer
		// VIP customers who are spending 10k per day 
	}

}
