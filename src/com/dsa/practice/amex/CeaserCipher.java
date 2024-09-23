package com.dsa.practice.amex;

public class CeaserCipher {
	//A Java Program to illustrate Caesar Cipher Technique 
	// Encrypts text using a shift of s 
	public static StringBuffer encrypt(String text, int shift) { 
		StringBuffer result= new StringBuffer(); 
		for (int i=0; i<text.length(); i++) { 
			char ch = text.charAt(i);
			if (Character.isUpperCase(ch)) { 
				ch = (char) ((ch + shift - 'A') % 26 + 'A');
				result.append(ch); 
			} else if (Character.isLowerCase(ch)) { 
				ch = (char) ((ch + shift - 'a') % 26 + 'a');
				result.append(ch); 
		    } else {
                // Non-alphabetic characters remain unchanged
                result.append(ch);
            }
		} return result; 
	} 
	
	// Decrypt the given text using the specified shift
    public static String decrypt(String text, int shift) {
        // Decrypting is just shifting back by the same amount
        return encrypt(text, 26 - shift).toString();
    }
    
	// Driver code 
	public static void main(String[] args) {
		String text = "A";
		int s = 4; 
		System.out.println("Text : " + text); 
		System.out.println("Shift : " + s); 
		String encrypted = encrypt(text, s).toString();
		System.out.println("Encrypted: " + encrypted);
		
		System.out.println("Decrypted: " + decrypt(encrypted, s)); 
		
		/***
		 *  Text : ATTACKATONCE
			Shift : 4
			Cipher: EXXEGOEXSRGI
		 */
	} 
}

