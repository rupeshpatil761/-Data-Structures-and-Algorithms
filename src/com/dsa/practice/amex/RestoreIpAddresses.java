package com.dsa.practice.amex;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	
	// Medium
	// https://leetcode.com/problems/restore-ip-addresses/description/
	
	public static void main(String[] args) {
		
		// Approach 1
		restoreIpAddressesApproach1("25525511135");
		//restoreIpAddressesApproach1("0000");
		//restoreIpAddressesApproach1("101023");		
		
		// Approach 2
		
		//restoreIpAddressesApproach2("25525511135");
		
		//Approach 3
		//bruteForceApproach("25525511135");
	}

	// Approach 1
	// https://leetcode.com/problems/restore-ip-addresses/solutions/3079573/java-solution-with-explanation/
	public static List<String> restoreIpAddressesApproach1(String s) {
		System.out.println("restoreIpAddressesApproach1 Input String: "+s);
		// Initialize the list to hold all valid IP addresses
		List<String> addresses = new ArrayList<>();
		// Initialize the list to hold the current IP address being built
		List<String> address = new ArrayList<>();
		// Call the recursive helper function to generate all possible IP addresses
		rec(s, 0, address, addresses);
		// Return the list of all valid IP addresses
		System.out.println("restoreIpAddressesApproach1 Possible IP addresses: "+addresses);
		return addresses;
	}

	private static void rec(String s, int i, List<String> address, List<String> addresses) {
		// If the current address has 4 segments, check if we have reached the end of
		// the input string
		if (address.size() == 4) {
			if (i == s.length()) {
				// If we have reached the end of the input string, add the current address to
				// the list of valid addresses
				addresses.add(String.join(".", address));
			}
		} else {
			// Try all possible next segments for the current address
			for (int j = i + 1; j <= i + 3 && j <= s.length(); j++) {
				String nextInt = s.substring(i, j);
				// Check if the next segment is valid (between 0 and 255, and not starting with
				// 0 unless it is 0)
				if (Integer.parseInt(nextInt) <= 255 && (nextInt.equals("0") || !nextInt.startsWith("0"))) {
					// Add the next segment to the current address
					address.add(nextInt);
					// Recursively call the function to generate the next segment
					rec(s, j, address, addresses);
					// Remove the last segment from the current address
					address.remove(address.size() - 1);
				}
			}
		}
	}
	
	// Approach 2
	// https://leetcode.com/problems/restore-ip-addresses/solutions/3079377/clean-codes-full-explanation-recursion-c-java-python3/
    private static List<String> restoreIpAddressesApproach2(String s) {
    	System.out.println("restoreIpAddressesApproach2 Input String: "+s);
        List<String> ans = new ArrayList<String>();
        recurse(s, ans, 0, "", 0);
        System.out.println("restoreIpAddressesApproach2 Possible IP addresses: "+ans);
        return ans;
    }
    private static void recurse(String curr, List<String> ans, int index, String temp, int count) {
        if (count > 4)
            return;
        if (count == 4 && index == curr.length())
            ans.add(temp);
        for (int i=1; i<4; i++) {
            if (index+i > curr.length()){
                break;
            }
            String s = curr.substring(index,index+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)){
                continue;
            }
            recurse(curr, ans, index+i, temp+s+(count==3?"" : "."), count+1);
        }
    }
    
    private static void bruteForceApproach(String str) {
    	System.out.println("bruteForceApproach Input String: "+str);
    	// 25525511135
    	List<String> result = runBruteForceApproach(str);
    	System.out.println("bruteForceApproach Possible IP addresses: "+result);
    	
    }
    
    private static List<String> runBruteForceApproach(String str){
    	
    	int len = str.length();
    	
    	if(len < 4 || len > 12) {
    		return new ArrayList<>();
    	}
    	
    	for(int aLen=1; aLen<=3; aLen++) {
    		for(int bLen=1; bLen<=3; bLen++) {
    			for(int cLen=1; cLen<=3; cLen++) {
    				
    				int dLen = len - aLen - bLen - cLen;
    				
    				if(dLen > 0 && dLen <=3 && aLen+bLen+cLen+dLen == len) {
    					Integer A = Integer.parseInt(str.substring(0, aLen));
    					Integer B = Integer.parseInt(str.substring(aLen, aLen + bLen));
    					Integer C = Integer.parseInt(str.substring(aLen + bLen, aLen + bLen + cLen));
    					Integer D = Integer.parseInt(str.substring(aLen + bLen + cLen));
    				}
    			}
    		}
    	}
    	
    	return null;
    }

	private static void generateIp(String str, int n, int i, int j, int k) {
		String n1 = str.substring(0, i+1);
		String n2 = str.substring(i+1, j-i);
	}
}
