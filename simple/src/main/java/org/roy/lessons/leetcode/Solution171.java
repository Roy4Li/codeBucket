package org.roy.lessons.leetcode;

public class Solution171 {

	public String convertToTitle(int n) {
		int MODE = 26;
		int remaining = 0;
		StringBuilder str = new StringBuilder("");
		while (n > 0) {
			remaining = n - n / MODE * MODE;
			str.append((char) (remaining > 0 ? remaining - 1 + 'A' : 'Z'));
			n = remaining == 0 ? n / MODE - 1 : n / MODE;
		}
		return str.reverse().toString();
	}

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++){
			System.out.printf("%-6s",new Solution171().convertToTitle(i));
		}
	}
}
