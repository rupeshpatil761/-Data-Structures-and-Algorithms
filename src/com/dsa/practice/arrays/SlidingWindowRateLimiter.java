package com.dsa.practice.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowRateLimiter {
    private final int maxRequests;
    private final long timeWindowInMillis;
    private final Deque<Long> requestTimestamps;

    public SlidingWindowRateLimiter(int maxRequests, long timeWindowInMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowInMillis = timeWindowInMillis;
        this.requestTimestamps = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        // Remove timestamps outside the time window
        while (!requestTimestamps.isEmpty() && now - requestTimestamps.peekFirst() > timeWindowInMillis) {
            requestTimestamps.pollFirst();
        }

        // Check if the number of requests is within the limit
        if (requestTimestamps.size() >= maxRequests) {
            return false; // Rate limit exceeded
        }

        // Add the current request timestamp
        requestTimestamps.offerLast(now);
        return true; // Request allowed
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(10, 60000); // 10 requests per 60 seconds

        // Simulate requests
        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + (i + 1) + ": " + (rateLimiter.allowRequest() ? "Allowed" : "Denied"));
        }
    }
}
