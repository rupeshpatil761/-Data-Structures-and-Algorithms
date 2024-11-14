package com.dsa.practice.amex;

public class VersionComparision {

	public static void main(String[] args) {
		System.out.println("Test 1 = " + new VersionNumber("4.65.00").compareTo(new VersionNumber("4.64.99")));
		System.out.println("Test 2 = " + new VersionNumber("1.00.001").compareTo(new VersionNumber("1.00.01")));
		System.out.println("Test 3 = " + new VersionNumber("2.05.011").compareTo(new VersionNumber("2.05.90")));
		System.out.println("Test 4 = " + new VersionNumber("1").compareTo(new VersionNumber("1.00")));
		System.out.println("Test 5 = " + new VersionNumber("02.01").compareTo(new VersionNumber("2.1")));
		
		System.out.println("New Test 1 = " + new VersionNumber("4.65.00").compareVersions("4.64.99"));
		System.out.println("New Test 2 = " + new VersionNumber("1.00.001").compareVersions("1.00.01"));
		System.out.println("New Test 3 = " + new VersionNumber("2.05.011").compareVersions("2.05.90"));
		System.out.println("New Test 4 = " + new VersionNumber("1").compareVersions("1.00"));
		System.out.println("New Test 5 = " + new VersionNumber("02.01").compareVersions("2.1"));
	}
}
class VersionNumber implements Comparable<VersionNumber> {
	private Integer major;
	private Double minor;
	private Double patch;
	
	public String compareVersions(String version) {
		int i = this.compareTo(new VersionNumber(version));
		String result = "Equal";
		if(i<0) {
			result = "Version 1 is less than Version 2";
		} else if(i > 0 ){
			result = "Version 1 is greater than Version 2";
		}
		return result;
	}
	
	@Override
	public int compareTo(VersionNumber version) {
		int majorComparision = this.major.compareTo(version.major);
		if(majorComparision == 0) {
			int minorComparision = this.minor.compareTo(version.minor);
			if(minorComparision == 0) {
				return this.patch.compareTo(version.patch);
			} else {
				return minorComparision;
			}
		} else {
			return majorComparision; 
		}
	}
	// [0-9]+ ensures that the string starts with one or more digits.
	// The + quantifier means "one or more" of the preceding element, so [0-9]+ matches a sequence of one or more digits.
	// (\\.[0-9]+)* allows for zero or more occurrences of a dot followed by one or more digits.
	// The parentheses () create a group. This group is optional due to the * quantifier at the end.
	// \\. matches a literal dot .. In regular expressions, the dot . is a special character, so we need to escape it with a backslash. 
	// In Java, the backslash itself needs to be escaped, so we use \\. to represent a literal dot.
	// The * quantifier means "zero or more" occurrences of the group (\\.[0-9]+).
	public VersionNumber(String versionText) {
		super();
		if(versionText==null || versionText.length()==0) {
			throw new IllegalArgumentException("Version cannot be null or empty");
		}
		if(!versionText.matches("[0-9]+(\\.[0-9]+)*")) {
			throw new IllegalArgumentException("Invalid Version");
		}
		String[] versions = versionText.split("\\.");
		this.major = Integer.valueOf(versions[0]);
		this.minor = versions.length > 1 ? Double.valueOf("0."+versions[1]) : 0d;
		this.patch = versions.length > 2 ? Double.valueOf("0."+removeLeadingZeros(versions[2])) : 0d;
	}
	
	private String removeLeadingZeros(String str) {
		if(str.length()==3 && str.startsWith("0")) {
			return str.substring(1);
		}
		return str;
	}

	@Override
	public String toString() {
		return "VersionNumber [major=" + major + ", minor=" + minor + ", patch=" + patch + "]";
	}
	
	
}