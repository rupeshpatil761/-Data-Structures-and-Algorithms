package com.dsa.practice.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class SummingIntExample {

	public static void main(String[] args) {

		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orange", 30, new BigDecimal("29.99")),
				new Item("orange", 20, new BigDecimal("29.99")), new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 10, new BigDecimal("19.99")), new Item("apple", 20, new BigDecimal("9.99")));
		
		/*
		 * Expected output 1
		 * output : apple, 40 banana,30 orange: 50
		 */
		
		Map<String, Integer> map = items.stream().collect(Collectors.groupingBy(Item::getName , TreeMap::new, Collectors.summingInt(Item::getQuantity)));
		
		System.out.println("output 1: "+map);
		
		
		// to reverse the order by key
		Map<String, Integer> map1 = items.stream().collect(Collectors.groupingBy(Item::getName , () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.summingInt(Item::getQuantity)));
		System.out.println("output 1 in reverse order : "+map1);
		
		
		/*
		 * Expected output 2
		 * output : orange: 50, apple: 40, banana: 30
		 */
		
		List<Map.Entry<String, Integer>> list1 =  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println("output 2 as list : "+list1);
		
		Map<String, Integer> map2 =  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println("output 2 as map : "+map2);
	}

}

class Item {
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	int quantity;
	BigDecimal price;

	public Item(String name, int quantity, BigDecimal price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
}