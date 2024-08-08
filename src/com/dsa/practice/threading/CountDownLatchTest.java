package com.dsa.practice.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++) {
			executorService.submit(new Processor(latch));
		}
		
		executorService.shutdown();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
		}
		
		System.out.println("Main thread completed");
	}
}

class Processor implements Runnable {
	
	private CountDownLatch latch = null;
	
	public Processor(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " - started");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		this.latch.countDown();
		
		System.out.println(Thread.currentThread().getName() + " - Completed");
	}
}