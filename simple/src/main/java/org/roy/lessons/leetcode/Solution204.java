package org.roy.lessons.leetcode;

public class Solution204 {

	public int countPrimes(int n) {
		int[] ints = new int[n];
		for (int i = 2; i * i < n; i++) {
			if (ints[i] == 0) {
				for (int j = i; j * i < n; j++)
					ints[i * j] = 1;
			}
		}
		int ret = 0;
		for (int i = 2; i < n; i++)
			if (ints[i] == 0)
				ret++;
		return ret;
	}

	public static void main(String[] args) {
		int x = 40;
		System.out.println(new Solution204().countPrimes(3));
	}
}
