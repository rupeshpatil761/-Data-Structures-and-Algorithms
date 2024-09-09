package com.dsa.practice.java8;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();;
		list.add("abc");
		System.out.println(list);
		
		List<String> list1 = new ArrayList<String>();;
		
		//List<String> list2 = new ArrayList<Object>();; // Error
		
		//List<Object> list3 = new ArrayList<String>(); // Error
		
	}

}
