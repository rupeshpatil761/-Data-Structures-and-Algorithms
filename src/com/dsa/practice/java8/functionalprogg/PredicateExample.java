package com.dsa.practice.java8.functionalprogg;

import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateExample {
	
	// Predicate takes single input and returns true/false
	
	public static void main(String[] args) {
        //all instructor who teaches online
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        //instructor experience is >10 years
        Predicate<Instructor> p2 = (i) -> i.getYearsOfExperience() >10;

        System.out.println("Instructors who teaches online are: ");
        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            if (p1.test(instructor)){
                System.out.println(instructor);
            }
        });

        // is instructor teaches online and exprience is > 10 years
        System.out.println("---------------------");
        System.out.println("Instructors with experiece > 10 years are: ");
        instructors.forEach(instructor ->  {
            if(p1.and(p2).test(instructor)){
                System.out.println(instructor);
            }
        });
        
        
        System.out.println("---------------------");
        
        System.out.println("-------IntPredicate: ");
        
        IntPredicate ip1 = (i) -> i>100;
        System.out.println(ip1.test(100));

        System.out.println("-------LongPredicate: ");
        LongPredicate lp2 = (i) -> i>100L;
        System.out.println(lp2.test(1111111111111111111L));

        System.out.println("-------DoublePredicate: ");
        DoublePredicate dp3 = (i) -> i<100.25;
        DoublePredicate dp4 = (i) -> i>100.10;
        System.out.println(dp3.and(dp4).test(100.15));

    }
}
