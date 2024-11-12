package com.dsa.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KapilJava8Questions {

	public static void main(String[] args) {

		// 1
		removeDupliactesFromString();

		// 2
		longestLengthWord();

		// 3
		secondHighestLengthWord();

		// 4
		lengthOfLongestWord();

		// 5
		secondHighestWordLength();

		// 6
		occuranceOfEachWord();

		// 7
		wordsWithMaximumVowels();

		// 8
		reverseStringWithSpecialChars();
		
		// 9
		divideTwoListWithEvenOddNos();
		
		// 10
		groupByRange();
		
		// 11
		seperateIntegersFromString();
		
		// 12
		uniqueNumsSum();
		
		// 13
		formSmallestPossibleNumber();
		
		// 14
		findFirstNonRepeatingWord();

	}

	private static void findFirstNonRepeatingWord() {
		// Given a String find the first non repeated character. (Google interview)
		// Output should be: 
		
		String str = "the quick brown fox jumps over the lazy dog";
		
		String res = Arrays.stream(str.split(" "))
				.filter(word -> str.indexOf(word) == str.lastIndexOf(word))
				.findFirst().get();
		
		System.out.println("findFirstNonRepeatingWord using indexOf : "+res);
		
		System.out.println(" -------------------");
		
		String firstNonRepeatingWord = Arrays.stream(str.split(" "))
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Step 2: Count occurrences of each word
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() == 1) // Filter non-repeating words
	            .map(Map.Entry::getKey) // Get the word (key) from the Map
	            .findFirst().orElse(""); // Get the first non-repeating word
		
		System.out.println("using groupigBy findFirstNonRepeatingWord : "+firstNonRepeatingWord);
	}

	private static void formSmallestPossibleNumber() {
		// Given a numeric array , re arrange the elements to form a smallest possible value.
		int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};  // output is: 133444576998
		
		String result = Arrays.stream(arr).mapToObj(e -> e+"").sorted().collect(Collectors.joining());
		
		System.out.println("SmallestPossibleNumber : "+result);
		
		result = Arrays.stream(arr).mapToObj(e -> e+"").sorted(Comparator.reverseOrder()).collect(Collectors.joining());
		
		System.out.println("HighestPossibleNumber : "+result);
		
		System.out.println(" -------------------");
	}

	private static void uniqueNumsSum() {
		// Given an array of integers arr = {5,6,7,8,5,5,8,8,7) find the sum of the unique elements. 
		//The output should be in this case is: 26.
		int[] arr = {5,6,7,8,5,5,8,8,7};
		int sum = Arrays.stream(arr).distinct().sum();
		System.out.println("uniqueNumsSum : "+sum);
		System.out.println(" -------------------");
	}

	private static void seperateIntegersFromString() {
		//Given a List of Strings  ["as", "123", "32", "2as"], create another Integer list that contains only integers. 
		//The output shoul be: List<Integer> iList = [123,32]
		
		String[] strings = {"as", "123", "32", "2as"};
		
		// "[0-9]*": This is the regular expression: [0-9]: Matches any single digit (0 through 9).
		// *: Means "zero or more occurrences" of the preceding element, which in this case is any digit.
		
		List<Integer> intergers = Arrays.stream(strings).filter(s -> s.matches("[0-9]*")).map(Integer::valueOf).collect(Collectors.toList());
		
		System.out.println("seperateIntegersFromString : "+intergers);
		
		System.out.println("-------------------");
	}

	private static void groupByRange() {
		//Given an array of integers (2, 34, 54, 23, 33, 20, 59, 11, 19, 37 ) group the numbers by the range they belong to. 
		// The output should be {0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
		
		int[] array = {2, 34, 54, 23, 33, 20, 59, 11, 19, 37};
		
		Map<Integer, List<Integer>> map = Arrays.stream(array).boxed().collect(Collectors.groupingBy(n -> n / 10 * 10, TreeMap::new, Collectors.toList()));
		
		System.out.println("groupByRange : "+map);
		
		System.out.println(" -------------------");
		
		//.boxed(): This method converts each primitive int into an Integer object. 
		// Since streams in Java are object-based, and Map keys and values require objects, we need to box the integers.
		
	}

	private static void divideTwoListWithEvenOddNos() {
		
		int[] array = {1,2,3,4,5,6,7,8,9};
		
		Map<Boolean, List<Integer>> partitionedList = Arrays.stream(array).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		
		System.out.println("partitionedList : "+partitionedList);
		
		System.out.println(" -------------------");
	}

	private static void reverseStringWithSpecialChars() {
		// Reverse a string with speical characters and Speical characters position
		// shouldn't be changed".
		String str = "Swa$pn&il";
		
		// stack approach
		stackApproach(str);
		
		System.out.println(" -------------------");
		
		// java approach
		
		String reverseString = new StringBuilder(str.replaceAll("[^0-9a-zA-Z]", "")).reverse().toString();
		
		String replacedString = str.replaceAll("[0-9a-zA-Z]", "_");
		
		char[] chars = reverseString.toCharArray();
		
		for(char ch : chars) {
			replacedString = replacedString.replaceFirst("_", String.valueOf(ch));
		}
		
		System.out.println("Reverse string using replaceAll and Regex : "+replacedString.toString());
		
		System.out.println(" -------------------");
	}
	

	private static void stackApproach(String str) {
		Stack<Character> charStack = new Stack<>(); // LIFO
		
		char[] chars = str.toCharArray();
		
		for(char ch: chars) {
			if(Character.isLetter(ch)) {
				charStack.push(ch);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch: chars) {
			if(Character.isLetter(ch)){
				sb.append(charStack.pop());
			} else {
				sb.append(ch);
			}
		}
		
		System.out.println("Reverse string using stack : "+sb.toString());
		
	}

	private static void wordsWithMaximumVowels() {
		// Given a string, find the words with the maximum number of vowels.

		String str = "The quick brown fox jumps right over the little lazy dog";
		// Maximum Number of Vowels: 2 | Output Words: quick, over, little ( because
		// each word has maximum of 2 vowels)

		// The ^ at the beginning of the square brackets [] indicates a negation,
		// meaning "not".
		// Thus, [^aeiouAEIOU] matches any character that is not a vowel (either
		// lowercase or uppercase).
		Arrays.stream(str.split(" ")).filter(s -> s.replaceAll("[^aeiouAEIOU]", "").length() == 2)
				.forEach(System.out::print);

		System.out.println(" \n-------------------");
	}

	private static void occuranceOfEachWord() {
		// Given a sentence, find the number of occurrence of each word.
		String input = "the quick brown fox jumps right over the little lazy dog little";
		Map<String, Long> resultMap = Arrays.stream(input.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("occuranceOfEachWord : " + resultMap);

		System.out.println("-------------------");
	}

	private static void secondHighestWordLength() {
		// Find the 2nd highest length word in the given sentence
		String str = "I am interested123455 to grow in my organization";

		int result = Arrays.stream(str.split(" ")).map(s -> s.length()).sorted(Comparator.reverseOrder()).skip(1)
				.findFirst().orElse(-1);

		System.out.println("secondHighestWordLength : " + result);

		System.out.println("-------------------");
	}

	private static void lengthOfLongestWord() {
		// Find the length of the longest word
		String s = "I am interested123455 to grow in my organization";
		Optional<Integer> length = Arrays.stream(s.split(" ")).map(String::length)
				.reduce((l1, l2) -> l2 > l1 ? l2 : l1);
		System.out.println("lengthOfLongestWord using reduce : " + length);

		// approach 2
		int length1 = Arrays.stream(s.split(" ")).mapToInt(l -> l.length()).max().getAsInt();
		System.out.println("lengthOfLongestWord using max : " + length1);

		System.out.println("-------------------");
	}

	private static void secondHighestLengthWord() {
		// Given a sentence find the word that has the 2nd (Nth) highest length.
		String s = "I am interested123455 to grow in my organization";
		String result = Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1)
				.findFirst().orElse("");
		System.out.println("secondHighestLengthWord : " + result);
		System.out.println("-------------------");
	}

	private static void longestLengthWord() {
		// Given a sentence find the word that has the highest length
		String s = "I am interested123455 to grow in my organization";
		Optional<String> result = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length));
		System.out.println("Hightest length string: " + result.get());
		System.out.println("-------------------");
	}

	private static void removeDupliactesFromString() {
		// 1) Remove duplicates from string and return in same order".
		String s = "dabfcadef";
		
		String result = s.chars().distinct().mapToObj(c -> (char) c).map(c -> c.toString())
				.collect(Collectors.joining());

		System.out.println("Result using s.chars(): " + result);

		result = Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
		System.out.println("Result using Arrays.stream(s.split(\"\")) : " + result);

		System.out.println(" -------------------");
	}
}
