package com.dsa.practice.amex;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.dsa.practice.amex.practice.StatPractice;

class StatisticsCalculatorJunitTests {
	
	private static int[] numbers = new int[1];
	
	@BeforeAll 
	public static void onlyOnce() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		numbers = convertToIntArray(input);
	}

	@Test
	public void testCalculateMean() {
		/*
		 * String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		 * int[] numbers = convertToIntArray(input);
		 */
		double expectedMean = 3610.125;
		assertEquals(expectedMean, StatPractice.calculateMean(numbers), 0.001);
	}
	
	@Test
	public void testCalculateMedian() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		double expectedMedian = 3288.5;
		assertEquals(expectedMedian, StatPractice.calculateMedian(numbers), 0.001);
	}
	
	@Test
	public void testCalculateMode() {
		String[] input = {"5346", "23", "973", "6382", "8821", "23", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		int expectedMode = 23;
		assertEquals(expectedMode, StatPractice.calculateMode(numbers));
	}
	
	@Test
	public void testCalculateRange() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		int expectedRange = 8819;
		assertEquals(expectedRange, StatPractice.calculateRange(numbers));
	}
	
	@Test
	public void testRange() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		assertIterableEquals(Arrays.asList(973, 1231, 5346),StatPractice.getNumbersInRange(numbers, 344,6000));//Nos in Range: [973, 1231, 5346]
	}
	
	private static int[] convertToIntArray(String[] input) {
		return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
	}
}
