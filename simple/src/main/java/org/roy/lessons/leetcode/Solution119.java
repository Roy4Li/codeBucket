package org.roy.lessons.leetcode;

import java.util.*;

public class Solution119 {

	public List<Integer> getRow(int rowIndex) {
		// extra space only needed
		List<Integer> ret = new ArrayList<Integer>(rowIndex + 1);
		for (int i = 0; i < rowIndex + 1; i++) {
			ret.add(1);
			if (i > 1) {
				for (int j = i - 1; j >= 1; j--) {
					ret.set(j, ret.get(j - 1) + ret.get(j));
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution119 instance = new Solution119();
		List<Integer> ret = instance.getRow(5);
		for (Integer i : ret)
			System.out.print(i + "  ");
	}
}