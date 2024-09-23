package com.dsa.practice.amex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TransactionsDesign {
  
   /* List<String> inputs = new ArrayList<>();
        //it has date price vendor category
        inputs.add("01/01/2023 $100.44 FitnessClub (Exercise)");
        inputs.add("05/07/2022 $50.25 Xerox (Instrument)");
        inputs.add("09/01/2021 $70.55 Apple (Food)");
        /**
        Given list of transactions in above format. Design and write production ready code to 
        query them for a date range, by vendor name or category. Also we should be able to do combo
        search like search by vendor and category.
        */
	
  /***
   * In interview: 
   * Talk about pagination to improve performance
   * Handle exceptions
   * 	
   */
	
  public static void main(String[] args) {
        
    // 1) Search by vendor OR category

    SearchService vendorSearchService = new VendorSearchService();
    SearchData searchData = new SearchData();
    searchData.vendorName = "Apple";

    List<Transaction> transactionsByVendor = vendorSearchService.searchRecords(searchData);
    System.out.println("transactionsByVendor: "+transactionsByVendor);

    System.out.println("---------------------");
    
    // 2) Search by vendor AND category
    SearchService categorySearchService = new CategorySearchService();
    searchData = new SearchData();
    searchData.categoryName = "Exercise";

    List<Transaction> transactionsByCategory = categorySearchService.searchRecords(searchData);
    System.out.println("transactionsByCategory: "+transactionsByCategory);
    
    System.out.println("---------------------");

    // 3) Search by date range
    SearchService dateRangeSearchService = new DateRangeSearchService();
    searchData = new SearchData();
    searchData.startDate = "01/01/2023";
    searchData.endDate = "10/01/2023";
    
    List<Transaction> transactionsByDateRange = dateRangeSearchService.searchRecords(searchData);
    System.out.println("transactionsByDateRange: "+transactionsByDateRange);
  }
  
}

class TransactionUtil {

   public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private static List<Transaction> transactionsList = new ArrayList<>();

  public static List<Transaction> getTestInputData(){

    if(!transactionsList.isEmpty()) {
      return transactionsList;
    }

    for(String input : getTextInput()) {
      String[] values = input.split(" ");
      LocalDate date = LocalDate.parse(values[0], dateFormatter);
      double price = Double.valueOf(values[1].substring(1));
      String vendor = values[2].replaceAll("[()]", "");
      String category = values[3].replaceAll("[()]", "");
      transactionsList.add(new Transaction(vendor, category, date, price));
    }

    return transactionsList;
  }

  private static List<String> getTextInput(){
    List<String> inputs = new ArrayList<>();
    inputs.add("01/01/2023 $100.44 FitnessClub (Exercise)");
        inputs.add("05/07/2022 $50.25 Xerox (Instrument)");
        inputs.add("09/01/2023 $70.55 Apple (Food)");
        return inputs;
  }
}

class Transaction {
  UUID id;
  String vendorName;
  String category;
  LocalDate date;
  double price;
  
  public Transaction() {}
  
  public Transaction(String vendorName, String category, LocalDate date, double price) {
    super();
    this.id = UUID.randomUUID();
    this.vendorName = vendorName;
    this.category = category;
    this.date = date;
    this.price = price;
  }
  // setter & getters
  // toString
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", vendorName=" + vendorName + ", category=" + category + ", date=" + date
			+ ", price=" + price + "]";
	}
}

interface SearchService {
   List<Transaction> searchRecords(SearchData searchData);
}

class VendorSearchService implements SearchService {
   @Override
   public List<Transaction> searchRecords(SearchData searchData) {

    if(searchData.vendorName == null || searchData.vendorName.length() < 1) {
      return new ArrayList<>();
    }

    List<Transaction> inputTransactions = TransactionUtil.getTestInputData();
     
    // can be used contains or equalsIgnoreCase
    return inputTransactions.stream()
      .filter(t -> t.vendorName.equalsIgnoreCase(searchData.vendorName))
      .collect(Collectors.toList());
   }
}

class CategorySearchService implements SearchService {
   @Override
   public List<Transaction> searchRecords(SearchData searchData) {
    
    if(searchData.categoryName == null || searchData.categoryName.length() < 1) {
      return new ArrayList<>();
    }

    List<Transaction> inputTransactions = TransactionUtil.getTestInputData();
    
      return inputTransactions.stream()
          .filter(t -> t.category.equalsIgnoreCase(searchData.categoryName))
          .collect(Collectors.toList());
   }
}

class DateRangeSearchService implements SearchService {
   @Override
   public List<Transaction> searchRecords(SearchData searchData) {
     
      if(searchData.startDate == null || searchData.endDate == null) {
          return new ArrayList<>();
      }
      List<Transaction> inputTransactions = TransactionUtil.getTestInputData();
      
      return inputTransactions.stream()
        .filter(t -> isInDateRange(t.date, searchData.startDate, searchData.endDate))
        .collect(Collectors.toList());
   }

   private static boolean isInDateRange(LocalDate targetDate, String start, String end) {
      LocalDate startDate = LocalDate.parse(start, TransactionUtil.dateFormatter);
      LocalDate endDate = LocalDate.parse(end, TransactionUtil.dateFormatter);
      return (targetDate.isEqual(endDate) || targetDate.isBefore(endDate)) &&  
          (targetDate.isEqual(startDate) || targetDate.isAfter(startDate));
  }
}

class SearchData {
  String vendorName;
  String categoryName;
  String startDate;
  String endDate;
}
