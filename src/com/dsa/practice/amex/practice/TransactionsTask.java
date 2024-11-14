package com.dsa.practice.amex.practice;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsTask {

	private static List<Transcation> transcationsList = new ArrayList<>();

	public static void main(String[] args) {

		List<String> inputTransactions = new ArrayList<>();
		inputTransactions.add("01/01/2023 $100.44 FitnessClub (Exercise)");
		inputTransactions.add("05/07/2022 $50.25 Xerox (Instrument)");
		inputTransactions.add("09/01/2021 $70.55 Apple (Food)");
		inputTransactions.add("11/01/2021 $80.55 Apple (Food)");
		inputTransactions.add("10/01/2021 $90.55 Apple (Food)");

		for (String inputTrnx : inputTransactions) {

			String[] array = inputTrnx.split(" ");

			LocalDate date = DateUtil.parseDate(array[0]);
			double price = Double.parseDouble(array[1].replace("$", ""));
			String vendor = array[2].replaceAll(" ", "");
			String category = array[3].replaceAll("[()]", "");
			transcationsList.add(new Transcation(vendor, category, price, date));
		}

		SearchData searchData = new SearchData();
		searchData.vendor = "Apple";

		VendorSearchService vendorService = new VendorSearchService();
		List<Transcation> vendorSpecificTrnxs = vendorService.searchRecords(searchData);
		System.out.println("vendorSpecificTrnxs: " + vendorSpecificTrnxs);

		CategorySearchService categoryService = new CategorySearchService();
		searchData.category = "Instrument";
		List<Transcation> categoryWiseTrnxs = categoryService.searchRecords(searchData);
		System.out.println("categoryWiseTrnxs: " + categoryWiseTrnxs);

		DateSearchService dateSearchService = new DateSearchService();
		searchData.startDate = "01/01/2022";
		searchData.endDate = "12/01/2023";
		List<Transcation> dateWiseTrnxs = dateSearchService.searchRecords(searchData);
		System.out.println("dateWiseTrnxs: " + dateWiseTrnxs);
		
		DateAndVendorSearchService dateAndVendorSearchService = new DateAndVendorSearchService();
		searchData.startDate = "09/01/2021";
		searchData.endDate = "11/01/2021";
		searchData.vendor = "Apple";
		String totalSum = dateAndVendorSearchService.getTotalAmountByDateAndVendor(searchData);
		System.out.println("totalSum: " + totalSum);
	}

	public static List<Transcation> getTranscationsData() {
		return transcationsList;
	}

}

class DateUtil {

	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	// string to LocalDate
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date, dateFormatter);
	}

	// LocalDate to string
	public static String formatDate(LocalDate date) {
		return date.format(dateFormatter);
	}

	public static boolean dateRangePredicate(LocalDate date, String startDate, String endDate) {
		LocalDate start = DateUtil.parseDate(startDate);
		LocalDate end = DateUtil.parseDate(endDate);
		
		if ((date.isEqual(start) || date.isAfter(start)) && (date.isEqual(end) || date.isBefore(end))) {
			return true;
		}
		return false;
	}
}

class VendorSearchService implements TransactionService {
	@Override
	public List<Transcation> searchRecords(SearchData searchData) {

		if (searchData.vendor == null || searchData.vendor.length() < 1) {
			return new ArrayList<>();
		}

		List<Transcation> transcations = TransactionsTask.getTranscationsData();

		return transcations.stream().filter(t -> t.getVendor().equalsIgnoreCase(searchData.vendor))
				.sorted(Comparator.comparing(Transcation::getDate))
				.collect(Collectors.toList());
	}
}

class CategorySearchService implements TransactionService {

	@Override
	public List<Transcation> searchRecords(SearchData searchData) {

		if (searchData.category == null || searchData.category.length() < 1) {
			return new ArrayList<>();
		}

		List<Transcation> transcations = TransactionsTask.getTranscationsData();

		return transcations.stream().filter(t -> t.getCategory().equalsIgnoreCase(searchData.category))
				.sorted(Comparator.comparing(Transcation::getDate))
				.collect(Collectors.toList());

	}
}

class DateSearchService implements TransactionService {
	
	private boolean dateRangeChecker(LocalDate trnxDate, String start, String end) {
		LocalDate startDate = DateUtil.parseDate(start);
		LocalDate endDate = DateUtil.parseDate(end);
		boolean result = (trnxDate.isEqual(startDate) || trnxDate.isAfter(startDate) && 
		trnxDate.isEqual(endDate) || trnxDate.isBefore(endDate));
		return result;
	}
	
	@Override
	public List<Transcation> searchRecords(SearchData searchData) {

		if (searchData.startDate == null && searchData.endDate == null) {
			return new ArrayList<>();
		}
		
		if(searchData.endDate == null){
			searchData.endDate =  DateUtil.formatDate(LocalDate.now());
		}
		

		List<Transcation> transcations = TransactionsTask.getTranscationsData();
		return transcations.stream()
				.filter(t -> dateRangeChecker(t.getDate(), searchData.startDate, searchData.endDate))
				.sorted(Comparator.comparing(Transcation::getDate))
				.collect(Collectors.toList());
	}
}

class DateAndVendorSearchService {
	

	public String getTotalAmountByDateAndVendor(SearchData searchData) {

		if (searchData.startDate == null || searchData.endDate == null) {
			return "$0.0";
		}

		if (searchData.vendor == null || searchData.vendor.length() < 1) {
			return "$0.0";
		}

		List<Transcation> transcations = TransactionsTask.getTranscationsData();

		double sumOfTrnx = transcations.stream()
				.filter(t -> DateUtil.dateRangePredicate(t.getDate(), searchData.startDate, searchData.endDate)
						&& t.getVendor().equalsIgnoreCase(searchData.vendor))
				.collect(Collectors.summingDouble(Transcation::getAmount));
		System.out.println("sumOfTrnx: " +sumOfTrnx);
		return "$" + new DecimalFormat("#.00").format(sumOfTrnx);
	}
}

interface TransactionService {

	List<Transcation> searchRecords(SearchData searchData);
}

class SearchData {
	String vendor;
	String category;
	double amount;
	String startDate;
	String endDate;
}

class Transcation {

	private String vendor;
	private String category;
	private double amount;
	private LocalDate date;

	public Transcation(String vendor, String category, double amount, LocalDate date) {
		super();
		this.vendor = vendor;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transcation [vendor=" + vendor + ", category=" + category + ", amount=" + amount + ", date="
				+ DateUtil.formatDate(date) + "]";
	}
}
