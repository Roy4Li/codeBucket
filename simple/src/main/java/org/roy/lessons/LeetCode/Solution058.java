package org.roy.lessons.LeetCode;

public class Solution058 {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		String[] arrayStr = s.split(" ");
		return arrayStr.length > 0 ? arrayStr[arrayStr.length - 1].length() : 0;
	}

	public static void main(String[] args) {
		Solution058 a = new Solution058();
		String[] arrStr = " ".split(" ");
		System.out.println(arrStr.length);
		for (String s : arrStr) {
			System.out.println(s);
		}
	}
}
