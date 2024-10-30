package com.dsa.practice.java8.streams;

import java.util.List;
import java.util.function.IntConsumer;

public class VariableScope {
	static int k = 0;

	public static void main(String[] args) {
		int b = 10; // local variable
		IntConsumer intConsumer = (a) -> System.out.println(a * 10);

		List<Instructor> instructors = Instructors.getAll();
		instructors.forEach(instructor -> {
			System.out.println(instructor + " " +k); // Local variable b defined in an enclosing scope must be final or effectively final
		});
		//b++; //Local variable b defined in an enclosing scope must be final or effectively final
		k++;
	}
}

/**
 * In lambda you are allowed to use the local variable but you cannot modify the local variable even though they
 * are not declared as final. This condition is called effectively final
 */
