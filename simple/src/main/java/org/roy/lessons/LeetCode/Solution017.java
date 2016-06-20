package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution017 {

	String[] dict;

	public void initDict() {
		dict = new String[10];
		dict[0] = "0";
		dict[1] = "1";
		dict[2] = "2abc";
		dict[3] = "3def";
		dict[4] = "4ghi";
		dict[5] = "5jkl";
		dict[6] = "6mno";
		dict[7] = "7pqrs";
		dict[8] = "8tuv";
		dict[9] = "9wxyz";
	}

	public void dfs(int index, int length, String src, String tmp,
			List<String> ret) {
		if (index == length) {
			ret.add(tmp);
		} else {
			for (int i = 1; i < dict[src.charAt(index) - '0'].length(); i++) {
				dfs(index + 1, length, src,
						tmp + dict[src.charAt(index) - '0'].charAt(i), ret);
			}
		}
	}

	public List<String> letterCombinations(String digits) {
		initDict();
		List<String> ret = new ArrayList<String>();
		if (digits.length() > 0)
			dfs(0, digits.length(), digits, new String(), ret);
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new Solution017().letterCombinations(""));
	}
}
