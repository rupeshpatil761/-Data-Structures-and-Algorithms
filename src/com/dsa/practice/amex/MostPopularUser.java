package com.dsa.practice.amex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class MostPopularUser {

	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		users.add(new User(1, List.of(1,2,4,5,3)));
		users.add(new User(2, List.of(1,5,3)));
		users.add(new User(3, List.of(3)));
		users.add(new User(4, List.of(5,3)));
		users.add(new User(5, List.of(1,2,3)));
		users.add(new User(6, List.of(1,2,3,4)));
		
		int mostPopularId = mostPopularUserId(users);
		
		System.out.println("mostPopularId: "+mostPopularId);
	}
	
	private static int mostPopularUserId(List<User> users) {
		
		List<Integer> subscriptions = users.stream().map(user -> user.subscriptions).flatMap(List::stream).collect(Collectors.toList());
		
		System.out.println("all subscriptions: "+subscriptions);
		
		Map<Integer, Long> resultMap = new HashMap<>();
		
		for(User user: users) {
			long count = subscriptions.stream().filter(sId -> sId == user.id).count();
			resultMap.put(user.id, count);
		}
		
		System.out.println("resultMap: "+resultMap);
		
		Optional<Map.Entry<Integer, Long>> popularUserEntry = resultMap.entrySet().stream().reduce((u1, u2) -> u1.getValue() > u2.getValue() ? u1 : u2);
		
		if(popularUserEntry.isPresent()) {
			System.out.println("Popular user using reduce: "+popularUserEntry.get());
		}
		
		Optional<Integer> mostPopularUserId = resultMap.entrySet().stream().sorted(Entry.comparingByValue((v1,v2)-> v2.compareTo(v1))).map(entry -> entry.getKey()).findFirst();
		
		return mostPopularUserId.isPresent() ? mostPopularUserId.get() : -1;
	}
}

class User {
	
	int id;
	
	List<Integer> subscriptions = new ArrayList<>();

	public User(int id, List<Integer> subscriptions) {
		super();
		this.id = id;
		this.subscriptions = subscriptions;
	}
}
