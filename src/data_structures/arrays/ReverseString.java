package data_structures.arrays;

public class ReverseString {

	public static void main(String[] args) {
		String str = "My Name is Rupesh";
		System.out.println("Original String: " + str);
		System.out.println("===========");
		reverseString1(str);
		System.out.println("===========");
		reverseString2(str);
		System.out.println("===========");
		reverseWords(str);
	}

	private static void reverseString1(String str) {
		if (str.length() < 2) {
			System.out.println("String is less than 2 chars");
			return;
		}

		char[] array = str.toCharArray();
		int length = array.length;

		char[] reverseArray = new char[length];

		int x = length - 1;
		for (int i = 0; i < array.length; i++) {
			reverseArray[i] = array[x--];
		}

		System.out.println("Reversed String using method 1: " + new String(reverseArray));
	}

	private static void reverseString2(String str) {

		if (str.length() < 2) {
			System.out.println("String is less than 2 chars");
			return;
		}

		String reverseString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverseString += str.charAt(i);
		}
		System.out.println("Reversed String using method 2: " + reverseString);
	}
	
	private static void reverseWords(String str) {
		String[] strArray = str.split(" ");
		if (strArray.length < 2) {
			System.out.println("String is less than 2 words");
			return;
		}
		String result = "";
		for (int i = strArray.length - 1; i >= 0; i--) {
			result += strArray[i]+" ";
		}
		System.out.println("Reversed Words: " + result);
	}

}
