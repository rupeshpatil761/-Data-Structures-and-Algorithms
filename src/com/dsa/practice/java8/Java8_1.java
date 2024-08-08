package com.dsa.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_1 {

	public static void main(String[] args) {
		 Integer[] input = new Integer[]{2, 4, 5, -1, 9, 6, 7, 1, 0, 9, 8, 10};
		 
		 List<Integer> list = Arrays.stream(input).
				 filter(n -> n >= 5).map(n -> n*n)
				 .distinct().collect(Collectors.toList());
		 System.out.println(list);
	}

}
