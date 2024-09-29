package com.dsa.practice.string;

public class RobotReturnToOrigin {

	// https://leetcode.com/problems/robot-return-to-origin/description/
	public static void main(String[] args) {
		String str = "LU";
		isReturnToOrigin(str);
	}

	private static void isReturnToOrigin(String moves) {

		boolean isReturnAtOrigin = false;
		char[] charArray = moves.toCharArray();
		int x = 0;
		int y = 0;
		for (char ch : charArray) {
			switch (ch) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			default:
				break;
			}
		}
		if(x==0 && y==0) {
			isReturnAtOrigin = true;
		}
		
		System.out.println("Is Robot Returing to Origin: "+isReturnAtOrigin + " | Final position of robot is: "+x +","+y);

	}

}
