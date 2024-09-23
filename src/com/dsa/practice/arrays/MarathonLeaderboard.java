package com.dsa.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MarathonLeaderboard {

    // Define the Runner class
    static class Runner {
        String name;
        double time; // time at 10-mile mark in minutes

        Runner(String name, double time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String toString() {
            return name + " - " + time + " minutes";
        }
    }

    // A comparator to sort runners by their time (ascending order)
    static class RunnerComparator implements Comparator<Runner> {
        @Override
        public int compare(Runner r1, Runner r2) {
            return Double.compare(r2.time, r1.time);
        }
    }

    public static void main(String[] args) {
        // Create a priority queue to hold the top 10 runners
        PriorityQueue<Runner> leaderboard = new PriorityQueue<>(10, new RunnerComparator());

        // Sample data: runners with their names and times at the 10-mile mark
        List<Runner> runners = Arrays.asList(
                new Runner("Alice", 55.3),
                new Runner("Bob", 52.1),
                new Runner("Charlie", 56.7),
                new Runner("David", 53.5),
                new Runner("Eve", 54.2),
                new Runner("Frank", 51.8),
                new Runner("Grace", 54.0),
                new Runner("Heidi", 53.1),
                new Runner("Ivan", 55.6),
                new Runner("Judy", 52.4),
                new Runner("Mallory", 57.2),
                new Runner("Niaj", 50.5), // Additional runner to test leaderboard size
                new Runner("Rupesh", 48.5),
                new Runner("Surya", 49.5),
                new Runner("Yogesh", 58.5)
        );

        // Process each runner and update the leaderboard
        for (Runner runner : runners) {
            if (leaderboard.size() < 10) {
                leaderboard.add(runner);
            } else if (leaderboard.comparator().compare(runner, leaderboard.peek()) < 0) {
                leaderboard.poll();
                leaderboard.add(runner);
            }
        }

        // Display the top 10 runners
        System.out.println("Top 10 Runners at the 10-Mile Mark:");
        List<Runner> sortedTopRunners = new ArrayList<>(leaderboard);
        Collections.sort(sortedTopRunners, new RunnerComparator());
        for (Runner runner : sortedTopRunners) {
            System.out.println(runner);
        }
    }
}
