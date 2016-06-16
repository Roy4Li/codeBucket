package org.roy.lessons.LeetCode;

public class Solution067 {

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return null;
		int index = digits.length - 1;
		while (index >= 0) {
			if (digits[index] < 9) {
				digits[index] += 1;
				return digits;
			} else {
				digits[index] = 0;
				index--;
			}
		}
		int[] ret = new int[digits.length + 1];
		if (index < 0) {
			ret[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				ret[i + 1] = digits[i];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int [] inp = {9,8,0,3,9};
		for(int i:inp)
			System.out.print(i+" ");
		Solution067 a = new Solution067();
		System.out.println("");
		int[] out = a.plusOne(inp);
		for(int i:out)
			System.out.print(i+" ");
	}
}
