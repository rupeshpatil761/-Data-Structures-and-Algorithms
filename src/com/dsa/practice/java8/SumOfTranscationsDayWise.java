package com.dsa.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumOfTranscationsDayWise {

	public static void main(String[] args) {
		// Given a list of transactions, find the sum of transaction amounts for each
		// day using Java streams:

		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));
		
		Map<String, Integer> resultMap =  transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
		
		System.out.println("resultMap: "+resultMap);
	}

}

class Transaction {
	String date;
	int amount;

	public Transaction(String date, int amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
