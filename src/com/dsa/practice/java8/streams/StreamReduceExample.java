package com.dsa.practice.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int results = numbers.stream()
				// 0 +1 = 1 //10+5= 15 //36+9=45
				// 1 + 2 = 3 //15+ 6= 21
				// 3 + 3 = 6 //21+7 = 28
				// 6+ 4 = 10 //28+8 = 36
				.reduce(0, (a, b) -> a + b);
		System.out.println(results);
		System.out.println("--------");
		// 1 * 1 = 1 //0*1 = 0 << if we put identity as 0 here, final result will be zero
		// 1 * 2 = 2 //0*2=0
		int results1 = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(results1);
		System.out.println("--------");
		// Reduce without identity
		Optional result2 = numbers.stream().reduce((a, b) -> a + b);
		if (result2.isPresent())
			System.out.println(result2.get());

		// MAX  || Similar for min
		int max = numbers.stream().reduce(0,(a,b) -> a>b?a:b);
		System.out.println("Max no: "+max);
		
		Optional maxNo = numbers.stream().max(Integer::compareTo);
		System.out.println("Max no using max(): "+maxNo.get());
		
	}
}
