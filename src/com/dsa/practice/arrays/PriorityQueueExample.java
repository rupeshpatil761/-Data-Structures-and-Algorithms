package com.dsa.practice.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {

		// Example:
		// input = [20, 10, 15, 30, 25, 12, 40]
		// output = [20, 20, 20, 30, 30, 30, 40]
		
		// if next element is lower than current element print higher number
		
		
		// by default natural ordering 
		Queue<Integer> testPq = new PriorityQueue<Integer>(new CustomComparator());
		testPq.add(20);
		testPq.add(10);
		testPq.add(15);
		testPq.add(30);
		testPq.add(25);
		testPq.add(12);
		testPq.add(40);
		
		while (!testPq.isEmpty()) {
			System.out.println(testPq.poll());
		}
		
		System.out.println("pq size: "+testPq.size());
		
	}
	
	static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? 1 : 0;
        }
    }
}
