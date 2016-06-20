package org.roy.lessons.LeetCode;

public class Solution171_2 {

	public int titleToNumber(String s) {
		int ret = 0;
		if (s != null && !s.isEmpty()) {
			for (char c : s.toCharArray()) {
				ret = ret * 26 + c + 1 - 'A';
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++)
			System.out.println(new Solution171_2().titleToNumber(new Solution171().convertToTitle(i)));
	}
}
