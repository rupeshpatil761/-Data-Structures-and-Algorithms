package com.dsa.practice.java8.lambda;

public class RunnableWithLambda {

	public static void main(String[] args) {
		
		// Implement using lambda
		Runnable runnable = () -> {
			int sum = 0;
			for(int i=0; i<10; i++) {
				sum++;
			}
			System.out.println("Sum is: "+sum);
			
		};
		new Thread(runnable).start();
		
		
		// Implement using Thread with lambda
		new Thread(() -> {
			int sum = 0;
			for(int i=0; i<10; i++) {
				sum++;
			}
			System.out.println("Sum is: "+sum);
		}).start();
		
	}

}
