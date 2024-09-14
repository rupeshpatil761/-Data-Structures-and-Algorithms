package com.dsa.practice.gsrrp;

public class PowerOfTenChecker {

	public static void main(String[] args) {
		System.out.println(isPowerOfTen(1)); // true, 10^0
        System.out.println(isPowerOfTen(10)); // true, 10^1
        System.out.println(isPowerOfTen(100)); // true, 10^2
        System.out.println(isPowerOfTen(1000)); // true, 10^3
        System.out.println(isPowerOfTen(30)); // false, not a power of 10
        System.out.println(isPowerOfTen(50)); // false, not a power of 10
        System.out.println(isPowerOfTen(0)); // false, 0 is not a power of 10
        System.out.println(isPowerOfTen(-10)); // false, negative numbers are not powers of 10
	}
	
	// The time complexity of the isPowerOfTen method is O(log10(n)), where n is the
	// input integer. This logarithmic complexity reflects the number of times you
	// need to divide the number by 10 until you reach 1 or determine that it cannot
	// be a power of 10.
	
	// Time complexity:  O(log10(n))
	// Space complexity: O(1)
	public static boolean isPowerOfTen(int number) {
		
		 // Negative numbers and zero are not powers of 10
		if(number <= 0) {
			return false;
		}
		
		// Divide the number by 10 until it becomes 1 or non-integer
		while (number > 1) {
			if(number % 10 != 0) {
				 return false; // If there's a remainder, it's not a power of 10
			}
			number /= 10; // Divide the number by 10
		}
		
		return number == 1; // Check if the final result is 1
	}
	
	/*@Test
    void testIsPowerOfTen() {
        // Test cases for positive powers of 10
        assertTrue(PowerOfTenChecker.isPowerOfTen(1), "1 should be a power of 10 (10^0)");
        assertTrue(PowerOfTenChecker.isPowerOfTen(10), "10 should be a power of 10 (10^1)");
        assertTrue(PowerOfTenChecker.isPowerOfTen(100), "100 should be a power of 10 (10^2)");
        assertTrue(PowerOfTenChecker.isPowerOfTen(1000), "1000 should be a power of 10 (10^3)");

        // Test cases for numbers that are not powers of 10
        assertFalse(PowerOfTenChecker.isPowerOfTen(0), "0 should not be a power of 10");
        assertFalse(PowerOfTenChecker.isPowerOfTen(-10), "Negative numbers should not be powers of 10");
        assertFalse(PowerOfTenChecker.isPowerOfTen(30), "30 should not be a power of 10");
        assertFalse(PowerOfTenChecker.isPowerOfTen(50), "50 should not be a power of 10");
        assertFalse(PowerOfTenChecker.isPowerOfTen(9), "9 should not be a power of 10");

        // Edge cases
        assertFalse(PowerOfTenChecker.isPowerOfTen(Integer.MAX_VALUE), "Integer.MAX_VALUE should not be a power of 10");
        assertFalse(PowerOfTenChecker.isPowerOfTen(Integer.MIN_VALUE), "Integer.MIN_VALUE should not be a power of 10");
    }*/

}
