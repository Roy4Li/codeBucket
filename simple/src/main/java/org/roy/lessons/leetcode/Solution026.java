package org.roy.lessons.leetcode;

public class Solution026 {

	public int removeDuplicates(int[] A) {
		int start = 0, end = 0;
		if (A == null || A.length == 0)
			return 0;
		for (int i = 0; i < A.length; i++) {
			if (A[start] != A[end]) {
				start++;
				if (end != start)
					A[start] = A[end];
			}
			end++;
		}
		return start + 1;
	}

	public static void main(String[] args) {

		Solution026 a = new Solution026();
		System.out.println();
	}
}
