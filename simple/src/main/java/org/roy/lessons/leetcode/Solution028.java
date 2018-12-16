package org.roy.lessons.leetcode;

import java.util.Vector;

public class Solution028 {

	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null)
			return -1;
		if(needle.length() == 0)
			return 0;
		if(haystack.length() == 0)
			return -1;
		
		char[] tar = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
		Vector<Integer> prefix = this.CptPrefix(pattern);
		int NOCM = 0; // Number of characters matched
		for (int i = 0; i < tar.length; i++) {
			while (NOCM > 0 && tar[i] != pattern[NOCM])
				NOCM = prefix.elementAt(NOCM);
			if (tar[i] == pattern[NOCM])
				NOCM++;
			if (NOCM == pattern.length) { // matched
				return i - pattern.length + 1;
			}
		}
		return -1;
	}

	public Vector<Integer> CptPrefix(char[] c) {
		if (c == null || c.length == 0)
			return null;
		int NOCM = 0; // Number of Character Matched
		int LOLP = 0; // Length of Longest Patter
		Vector<Integer> prefix = new Vector<Integer>(c.length);
		prefix.add(0);
		prefix.add(0);
		for (NOCM = 2; NOCM < c.length; NOCM++) {
			while (LOLP > 0 && c[NOCM-1] != c[LOLP])
				LOLP = prefix.elementAt(LOLP);
			if (c[NOCM-1] == c[LOLP])
				LOLP++;
			prefix.add(NOCM, LOLP);
		}
		return prefix;
	}

	public static void main(String[] args) {
		Solution028 a = new Solution028();
//		char[] c = "aaaaaaaaaaaaaaa".toCharArray();
//		Vector<Integer> prefix = a.CptPrefix(c);
//
//		for (int i = 0; i < c.length; i++) {
//			System.out.print(c[i] + "  ");
//		}
//		System.out.println();
//		for (int i = 0; i < c.length; i++) {
//			System.out.print(prefix.elementAt(i) + "  ");
//		}
		int i = a.strStr("mississippi", "issip");
		System.out.println(i);
	}
}
