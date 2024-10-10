package com.dsa.practice.java8;

import java.util.Arrays;
import java.util.List;

public class AverageAgeOfPersons {

	public static void main(String[] args) {
		List<Person1> persons = Arrays.asList(
			    new Person1("Alice", 25),
			    new Person1("Bob", 30),
			    new Person1("Charlie", 35)
			);

		double average = persons.stream().mapToInt(p -> p.getAge()).average().orElse(0);
	}
}
class Person1 {
	String name;
	Integer age;
	public Person1(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}