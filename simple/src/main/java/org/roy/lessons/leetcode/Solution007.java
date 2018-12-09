package org.roy.lessons.leetcode;

public class Solution007 {
	public int reverse(int x) {
		int sign = 1, num = 0, odd = 0;
		if (x < 0) {
			if(x == Integer.MIN_VALUE)
				return 0;
			sign = -1;
			x = -x;
		}
		while (x != 0) {
			odd = x % 10;
			x /= 10;
			if (num > Integer.MAX_VALUE / 10){ // do not need to check num == MAX_VALUE / 10 because it won't be.
				num = 0;
				break;
			}
			num = num * 10 + odd;
		}
		return sign * num;
	}

	public static void main(String[] args) {
		int[] x = {123, 100, 300, -900,-1000000003,-2147483648};
		Solution007 a = new Solution007();
		for (int i : x) {
			System.out.println(a.reverse(i));
		}
	}
}
