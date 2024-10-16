package com.dsa.practice.amex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class StatisticsCalculatorJunitTests {

	@Test
	public void testCalculateMean() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		double expectedMean = 3610.125;
		assertEquals(expectedMean, StatisticsCalculator.calculateMean(numbers), 0.001);
	}
	
	@Test
	public void testCalculateMedian() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		double expectedMedian = 3288.5;
		assertEquals(expectedMedian, StatisticsCalculator.calculateMedian(numbers), 0.001);
	}
	
	@Test
	public void testCalculateMode() {
		String[] input = {"5346", "23", "973", "6382", "8821", "23", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		int expectedMode = 23;
		assertEquals(expectedMode, StatisticsCalculator.calculateModeNew(numbers));
	}
	
	@Test
	public void testCalculateRange() {
		String[] input = {"5346", "23", "973", "6382", "8821", "2", "1231", "6103"};
		int[] numbers = convertToIntArray(input);
		int expectedRange = 8819;
		assertEquals(expectedRange, StatisticsCalculator.calculateRange(numbers));
	}
	
	private int[] convertToIntArray(String[] input) {
		return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
	}
}
