package com.dsa.practice.threading;

public class ThreadLocalTest {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocalObj = new ThreadLocal();
		
		threadLocalObj.set(Thread.currentThread().getName());
		
		Thread t1 = new Thread(() -> {
			threadLocalObj.set(Thread.currentThread().getName());
			System.out.println("ThreadLocal value in t1: "+ threadLocalObj.get());
			
			// make sure to cleanup if reusing the thread
			
			threadLocalObj.remove();
		});
		
		t1.start();
		
		System.out.println("ThreadLocal value in main: "+ threadLocalObj.get());
		
		threadLocalObj.remove();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		
		System.out.println("ThreadLocal after done: "+ threadLocalObj.get());
	}

}
