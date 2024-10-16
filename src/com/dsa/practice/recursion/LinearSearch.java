package com.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 5, 7, 6 };
		int target = 5;
		int index = findIndex(arr, target, 0);
		System.out.println("Index: " + index);

		index = findIndexFromLast(arr, target, arr.length - 1);
		System.out.println("Index from last: " + index);
		
		List<Integer> indexes = findIndexes(arr, target, new ArrayList<Integer>());
		System.out.println("Indexes: " + indexes);
	}
	
	private static List<Integer> findIndexes(int[] arr, int target, List<Integer> list) {
		list.add(findIndex(arr, target, 0));
		list.add(findIndexFromLast(arr, target, arr.length - 1));
		return list;
	}

	private static int findIndex(int[] arr, int target, int i) {
		if (i > arr.length - 1) {
			return -1;
		}
		if (arr[i] == target) {
			return i;
		} else {
			return findIndex(arr, target, i + 1);
		}
	}

	private static int findIndexFromLast(int[] arr, int target, int i) {
		if (i < 0) {
			return -1;
		}
		if (arr[i] == target) {
			return i;
		} else {
			return findIndexFromLast(arr, target, i - 1);
		}
	}
}
