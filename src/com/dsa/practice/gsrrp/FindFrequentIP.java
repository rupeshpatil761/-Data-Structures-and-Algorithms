package com.dsa.practice.gsrrp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindFrequentIP {

	public static void main(String[] args) {
		String[] array = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"};
		HashMap<String, Integer> map = new HashMap<>();
		for(String str: array) {
			 // Extract IP address
            String ip = str.split(" - ")[0];
            map.put(ip, map.getOrDefault(ip, 0) + 1);
		}
		
		System.out.println(map);
		
		Optional<String> result =  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).
				map(entry -> entry.getKey()).findFirst();
		
		System.out.println(result+ "<<<<<<<<<result");
		
        String mostFrequentIP = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        
        System.out.println(mostFrequentIP+ "<<<<<<<<<mostFrequentIP");

	}

}
