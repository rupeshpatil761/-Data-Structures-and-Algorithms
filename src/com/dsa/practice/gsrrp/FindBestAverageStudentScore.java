package com.dsa.practice.gsrrp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindBestAverageStudentScore {
	
	//Having student name and test score (array), count best average grade. 
	//Student may have more than one test score

	public static void main(String[] args) {
		// Sample data: (name, score)
        String[][] data = {
            {"Alice", "85"},
            {"Bob", "92"},
            {"Alice", "90"},
            {"Bob", "88"},
            {"Alice", "95"},
            {"Bob", "85"}
        };
        
        // create a map
        Map<String, int[]> studentMap = new HashMap<>();
        
        for(String[] entry : data) {
        	String name = entry[0];
        	int score = Integer.parseInt(entry[1]);
        	
        	studentMap.putIfAbsent(name, new int[]{0,0}); // sum , count
        	
        	// update score and count if student exist
        	int[] scores = studentMap.get(name);
        	scores[0] += score;
        	scores[1] += 1;
        }
        
		studentMap.entrySet().forEach(
				entry -> System.out.println("Student: " + entry.getKey() + " - " + Arrays.toString(entry.getValue())));
		
		// find best student or average grade
		String bestStudent = "";
		double bestAverageGrade = -1;
		
		for(Map.Entry<String, int[]> entry : studentMap.entrySet()) {
			String student = entry.getKey();
			int[] score = entry.getValue();
			double average = (double) score[0] / score[1];
			if(average > bestAverageGrade) {
				bestAverageGrade = average;
				bestStudent = student;
			}
		}
		 // Output the result
        System.out.println("The student with the best average grade is: " + bestStudent);
        System.out.println("Their average grade is: " + bestAverageGrade);
		
	}

}
