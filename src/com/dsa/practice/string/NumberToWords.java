package com.dsa.practice.string;

public class NumberToWords {

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] thousands = {
        "", "thousand", "lakh"
    };

    public static String convertToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder words = new StringBuilder();

        if (number >= 100000) {
            words.append(convertHundreds(number / 100000)).append(" lakh ");
            number %= 100000;
        }
        if (number >= 1000) {
            words.append(convertHundreds(number / 1000)).append(" thousand ");
            number %= 1000;
        }
        if (number > 0) {
            words.append(convertHundreds(number));
        }

        return words.toString().trim();
    }

    private static String convertHundreds(int number) {
        StringBuilder words = new StringBuilder();

        if (number >= 100) {
            words.append(units[number / 100]).append(" hundred ");
            number %= 100;
        }
        if (number >= 20) {
            words.append(tens[number / 10]).append(" ");
            number %= 10;
        }
        if (number > 0) {
            words.append(units[number]).append(" ");
        }

        return words.toString().trim();
    }

    public static void main(String[] args) {
        int number = 576;
        String words = convertToWords(number);
        System.out.println(words); // Output: one lakh twenty-three thousand four hundred and fifty-six
    }
}
