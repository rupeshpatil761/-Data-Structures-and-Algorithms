package com.dsa.practice.gsrrp;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
	
	// Solution: // https://www.youtube.com/watch?v=9jW8Bk24zz4
	// https://www.geeksforgeeks.org/longest-repeating-subsequence/

	public static void main(String[] args) {
		System.out.println("Result: "+longestRepeatingSubstringUsingRecursion("aabb"));
		System.out.println("Result: "+longestRepeatingSubstringUsingRecursion("axxxy"));
		System.out.println("Result: "+longestRepeatingSubstringUsingRecursion("abacbc"));
		
	}
	
	// Time Complexity: O(m * n) - Each cell in the dp table is filled in constant time.
	// Space Complexity: O(m * n) - For storing the dp table.
	private static int longestRepeatingSubstringUsingRecursion(String str1) {
		String str2 = str1;
		int n = str1.length();
		// to overcome overlapping subproblem use dp(dynamic programming) array
		int[][] dp = new int[n + 1][n + 1];
		for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
		return recursion(str1, str2, 0, 0, dp);
	}
	
	private static int recursion(String str1, String str2, int i, int j, int[][] dp) {
		if (str1.length() == i || str2.length() == j) {
			return 0;
		}

		// if value is already evaluated return the same
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		// we need to compare if the chars are equals and positions are different
		if (str1.charAt(i) == str2.charAt(j) && i != j) {
			// increase the size and increment the both pointers
			return dp[i][j] = recursion(str1, str2, i + 1, j + 1, dp) + 1;
		} else {
			// try to increase one pointer at a time and return max of both
			// this might increase the calls exponentially so that use dp array in between
			// *******8 Because of these two lines time complexity comes to o(m*n)
			int c1 = recursion(str1, str2, i + 1, j, dp);
			int c2 = recursion(str1, str2, i, j + 1, dp);
			int max = Math.max(c1, c2);
			return dp[i][j] = max;
		}
	}
	// Brute force Solution
	//  T: O(n2) && S: O(n2) 
	// https://www.youtube.com/watch?v=oL7GCrcdaJI
	static int findLongestRepeatingSubSeqBruteForce(String str)
    {
        int n = str.length();
  
        // Create and initialize DP table
        int[][] dp = new int[n+1][n+1];
  
        // Fill dp table (similar to LCS loops)
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                // If characters match and indexes are not same
                if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
                    dp[i][j] =  1 + dp[i-1][j-1];          
                       
                // If characters do not match
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }
}

/*
Examples 

Input: str = "abc"
Output: 0
There is no repeating subsequence

Input: str = "aab"
Output: 1
The two subsequence are 'a'(first) and 'a'(second). 
Note that 'b' cannot be considered as part of subsequence 
as it would be at same index in both.

Input: str = "aabb"
Output: 2

Input: str = "axxxy"
Output: 2

*/
