package com.dsa.practice.string;

public class ReverseWordsInString {

	public static void main(String[] args) {
		
		String str = "the sky is blue";
		
		//String str = "  hello world  ";
		
		//String str = "a good   example";
		
		String[] strArray = str.trim().split(" +");
		StringBuilder builder = new StringBuilder();
		for(int i=strArray.length-1; i>=0; i--) {
			builder.append(strArray[i]+" ");
		}
		System.out.println("Result: "+builder.toString().trim());
	}

}
