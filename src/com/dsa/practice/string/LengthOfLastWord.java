package com.dsa.practice.string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = " Hello World ";
		
		str = "fly to the moon ";
		
		int count = 0;
		
		str = str.trim();
		
		for(int i = str.length()-1; i>=0; i--) {
			if(str.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}
		
		System.out.println("Count: "+count);
	}

}
