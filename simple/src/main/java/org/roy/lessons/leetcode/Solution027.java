package org.roy.lessons.leetcode;

public class Solution027 {

	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;
		int start = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[start] = A[i];
				start++;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int [] A ={2};
		int b = 3;
		Solution027 a = new Solution027();
		System.out.println(a.removeElement(A, b));
	}
}
