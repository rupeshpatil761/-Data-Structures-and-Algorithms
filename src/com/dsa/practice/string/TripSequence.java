package com.dsa.practice.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TripSequence {

	public static void main(String[] args) {
		
		//List has trip(one-way) tickets in random order as below, 
		//print them in sequence by finding the exact origin

		//Input: List tripTickets = Arrays.asList("KOL-BOM", "BOM-DEL", "HYD-KOL");
		//Output: HYD-KOL, KOL-BOM, BOM-DEL
		
		//https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
		
		/***
		 * Steps:
		 * Create hashmap of start-end cities. i.e. dataset
		 * Get the values from map i.e. targetCities
		 * Check if map.getKey contains in targetCities.... if not contains that is start city
		 * Once we get start city -- loop through dataset from startCity
		 */
		
		List<String> tripTickets = Arrays.asList("Banglore-Chennai", "Delhi-Bombay", "Chennai-Goa", "Goa-Delhi");
		
		Map<String,String> dataset = new LinkedHashMap<>(); // from-to 
		
		for (String trip : tripTickets) {
			String src = trip.split("-")[0];
			String target = trip.split("-")[1];
			dataset.put(src, target);
		}
		
		//System.out.println(dataset +" <<< map");
		
		// get the values map or list
		List<String> targetCities = dataset.values().stream().collect(Collectors.toList());
		
		String startCity = null;
		
		for(Map.Entry<String,String> entrySet : dataset.entrySet()) {
			
			if(!targetCities.contains(entrySet.getKey())){
				startCity = entrySet.getKey();
			}
			
		}
		System.out.println(startCity +" <<< startCity");
		
		if (startCity == null) 
        { 
           System.out.println("Invalid Input"); 
           return; 
        } 
		
		// Once we have starting point, we simple need to go next, next 
        // of next using given hash map 
		String toCity = dataset.get(startCity);
		while(toCity != null) {
			System.out.println(startCity +" -> " + toCity +", ");
			startCity = toCity;
			toCity = dataset.get(startCity);
		}
		
	}

}

