package org.roy.lessons.leetcode;

import java.util.*;

public class Solution022 {

	public void binaryTraversal(String s, int m, int n, List<String> ret) {
		if (m == 0 && n == 0) {
			ret.add(s);
		} else {
			if (m > 0) {
				binaryTraversal(s + "(", m - 1, n, ret);
			}
			if (n > 0 && m < n) {
				binaryTraversal(s + ")", m, n - 1, ret);
			}
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<String>();
		if (n > 0)
			binaryTraversal("", n, n, ret);
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new Solution022().generateParenthesis(5));
	}
}
