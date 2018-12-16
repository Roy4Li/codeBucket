package org.roy.lessons.leetcode;

public class Solution005 {
	public String longestPalindrome(String s) {
		boolean[][] isPalin = new boolean[s.length()][s.length()];

		char[] chars = s.toCharArray();
		int len = chars.length;
		int beginIndex = 0, maxLength = 1;
		if(s.length() < 2) return s;
		// length is 1
		for (int i = 0; i < chars.length; i++)
			isPalin[i][i] = true;
		// length is 2
		for (int i = 0; i < len - 1; i++) {
			if (chars[i] == chars[i + 1]) {
				isPalin[i][i + 1] = true;
				beginIndex = i;
				maxLength = 2;
			}
		}
		// length >= 3
		for (int length = 3; length <= len; length++) {
			for (int i = 0; i < len - length + 1; i++) {
				int j = i + length - 1;
				if (chars[i] == chars[j] && isPalin[i + 1][j - 1]) {
					isPalin[i][j] = true;
					beginIndex = i;
					maxLength = length;
				}
			}
		}
		return s.substring(beginIndex, beginIndex + maxLength);
	}

	public static void main(String[] args) {
		String s = "adadc";
		System.out.println(new Solution005().longestPalindrome(s));
	}
}
