package com.dsa.practice.java8;

import java.util.Arrays;

public class KthSmallestElement {
	public static void main(String[] args) {
		int[] array = {4, 2, 7, 1, 5, 3, 6};
		int k = 2;
		
		int smallestNo = Arrays.stream(array).boxed().sorted().skip(k-1).findFirst().orElse(-1);
		System.out.println(smallestNo);
	}
}
