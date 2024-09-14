package com.dsa.practice.string;

import java.util.Arrays;

public class LongestCommonSubsequence {

	// https://www.youtube.com/watch?v=e9tUPwZZSBI
	//https://github.com/nikoo28/java-solutions/blob/master/src/test/java/leetcode/medium/LongestCommonSubsequenceTest.java

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "acbcf";
		
		str1 = "AGGTAB";
        str2 = "GXTXAYB";
		System.out.println("BF Result: " + longestCommonSubsequenceBruteForce(str1, str2));
		System.out.println("Recusrion Result: " + lcsUsingRecursionMain(str1, str2));
		System.out.println("--------------------------------");
		
		str1 = "skjbfbkjlsehefiuwehsensuibefewjkbde";
		str2 = "wjlxheniugcfnweyncwgfcwurycouivghucntgxuoiwhm";
		System.out.println("BF Result: " + longestCommonSubsequenceBruteForce(str1, str2));
		System.out.println("--------------------------------");

		str1 = "abc";
		str2 = "def";
		System.out.println("BF Result: " + longestCommonSubsequenceBruteForce(str1, str2));
		System.out.println("--------------------------------");

		str1 = "abcdaf";
		str2 = "";
		System.out.println("Result: " + longestCommonSubsequenceBruteForce(str1, str2));

	}

	// time complexity: O(n2)
	// space complexity: o(n + m)
	private static int longestCommonSubsequenceBruteForce(String text1, String text2) {
		// Construct dp matrix (dynamic programming)
		int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // with extra 1 size

		// Iterate over each cell and update values
		for (int i = 1; i <= text1.length(); i++) {

			for (int j = 1; j <= text2.length(); j++) {
				
				// ****** We do not need to check for positions whether they are same or not
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1]; // if chars are same take prev value and add 1 to it
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // if chars are not same, take max of prev values
				}
			}
		}
		// Return the value in last cell
		return dp[text1.length()][text2.length()];
	}
	
	// recursive approach 
	//https://www.youtube.com/watch?v=0yvOxPwe3Dg
	// https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
	// Time Complexity: O(m * n) ,where m and n are lengths of strings S1 and S2.
	// Auxiliary Space: O(m * n)
	private static int lcsUsingRecursionMain(String S1, String S2) {
		int m = S1.length();
        int n = S2.length();
        int[][] memo = new int[m + 1][n + 1];

        // Initialize the memo table with -1
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
		return lcsRecursion(S1, S2, 0, 0, memo);
	}
			
	private static int lcsRecursion(String str1, String str2, int i, int j, int[][] dp) {
		if (str1.length() == i || str2.length() == j) {
			return 0;
		}

		// if value is already evaluated return the same
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		// Match
		// ****** We do not need to check for positions whether they are same or not
		if (str1.charAt(i) == str2.charAt(j)) {
			// increase the size and increment the both pointers
			return dp[i][j] = lcsRecursion(str1, str2, i + 1, j + 1, dp) + 1;
		} else {
			// try to increase one pointer at a time and return max of both
			// this might increase the calls exponentially so that use dp array in between
			// *******8 Because of these two lines time complexity comes to o(m*n)
			int c1 = lcsRecursion(str1, str2, i + 1, j, dp);
			int c2 = lcsRecursion(str1, str2, i, j + 1, dp);
			int max = Math.max(c1, c2);
			return dp[i][j] = max;
		}
	}

}
