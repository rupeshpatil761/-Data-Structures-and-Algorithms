package com.dsa.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8_FlatMap {

	/*
	 * Coding Task 1: Core Java (20 mins) You are given a list of Person objects,
	 * each containing attributes name, age, and hobbies. Write a Java program using
	 * Stream API to find the top N most common hobbies among people aged between 20
	 * and 30 (inclusive). Finally, return a list of unique hobbies sorted in
	 * descending order based on their frequency.
	 */
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();

		personList.add(new Person("abc", 21, Arrays.asList("hobby1", "hobby2")));
		personList.add(new Person("abcd", 14, Arrays.asList("hobby11", "hobby2")));
		personList.add(new Person("abd", 30, Arrays.asList("hobby2", "hobby3")));
		personList.add(new Person("ard", 25, Arrays.asList("hobby5", "hobby2")));
		personList.add(new Person("asa", 24, Arrays.asList("hobby3", "hobby1")));
		personList.add(new Person("asas", 56, Arrays.asList("hobby4", "hobby3")));

		List<String> hobbies = personList.stream().filter(person -> person.age >= 20 && person.age <= 30)
				.flatMap(person -> person.hobbies.stream()).collect(Collectors.toList());
		
		System.out.println(hobbies +" <<<<<<hobbies");

		Map<String, Long> hobbiesCountMap = hobbies.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(hobbiesCountMap + " <<<<<<<hobbiesCountMap");
		
		int N =2;

		List<String> hobbiesInDescOrder = hobbiesCountMap.entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
				.map(entry -> entry.getKey()).limit(N).collect(Collectors.toList());
		
		System.out.println(hobbiesInDescOrder + "<--- N i.e. "+N+" hobbiesInDescOrder by their frequency");

	}

}

class Person {
	String name;
	int age;
	List<String> hobbies;

	public Person() {
	}

	public Person(String name, int age, List<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}
}
