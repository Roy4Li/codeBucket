package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution012 {
	public String intToRoman(int num) {
		StringBuilder str = new StringBuilder();
		char[] chars;
		char char1 = 0, char5=0,char10=0;
		int mode = 1000;
		while (mode > 0) {
			int c = num / mode;
			num %= mode;
			switch (mode) {
			case 1000:
				char1 = 'M';
				if(c > 3)
					return "error";
				break;
			case 100:
				char1 = 'C';
				char5 = 'D';
				char10 = 'M';
				break;
			case 10:
				char1 = 'X';
				char5 = 'L';
				char10 = 'C';
				break;
			case 1:
				char1 = 'I';
				char5 = 'V';
				char10 = 'X';
				break;
			default:
				break;
			}
			if (c == 9)
				str.append(char1).append(char10);
			else if (c >= 5) { // 5 --- 8
				chars = new char[c - 5 + 1];
				Arrays.fill(chars, char1);
				chars[0] = char5;
				str.append(chars);
			} else if (c == 4) // 4
				str.append(char1).append(char5);
			else if(c > 0){ // 1 --- 3
				chars = new char[c];
				Arrays.fill(chars, char1);
				str.append(chars);
			}
			mode /= 10;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		int num = 5;
		System.out.println(new Solution012().intToRoman(num));
	}
}
