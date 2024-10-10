package com.dsa.practice.amex;

public class VersionComparision {

	public static void main(String[] args) {
		System.out.println("Test 1 = " + new VersionNumber("4.65.00").compareTo(new VersionNumber("4.64.99")));
		System.out.println("Test 2 = " + new VersionNumber("1.00.001").compareTo(new VersionNumber("1.00.01")));
		System.out.println("Test 3 = " + new VersionNumber("2.05.011").compareTo(new VersionNumber("2.05.90")));
		System.out.println("Test 4 = " + new VersionNumber("1").compareTo(new VersionNumber("1.00")));
		System.out.println("Test 5 = " + new VersionNumber("02.01").compareTo(new VersionNumber("2.1")));
	}
}
class VersionNumber implements Comparable<VersionNumber> {
	private Integer major;
	private Double minor;
	private Double point;
	
	@Override
	public int compareTo(VersionNumber version) {
		int majorComparision = this.major.compareTo(version.major);
		if(majorComparision == 0) {
			int minorComparision = this.minor.compareTo(version.minor);
			if(minorComparision == 0) {
				return this.point.compareTo(version.point);
			} else {
				return minorComparision;
			}
		} else {
			return majorComparision; 
		}
	}
	
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
		this.point = versions.length > 2 ? Double.valueOf("0."+removeLeadingZeros(versions[2])) : 0d;
	}
	
	private String removeLeadingZeros(String str) {
		if(str.length()==3 && str.startsWith("0")) {
			return str.substring(1);
		}
		return str;
	}
}