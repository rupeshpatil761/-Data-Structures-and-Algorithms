package com.dsa.practice.string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = " Hello World ";

		str = "fly to the moon ";

		int count = 0;

		str = str.trim();

		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}

		System.out.println("Count: " + count);

		System.out.println("Output using solution2 : " + solution2(str));

		System.out.println("Output using solution3 : " + lengthOfLastWord(str));
	}

	private static int solution2(String str) {
		return str.trim().length() - str.trim().lastIndexOf(" ") - 1;
	}

	private static int lengthOfLastWord(String str) {
		String[] strArray = str.split("\\s");
		return strArray[strArray.length - 1].length();
	}

}
