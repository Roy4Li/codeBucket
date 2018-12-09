package org.roy.lessons.leetcode;

public class Solution029 {

	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			if(divisor == 1)
				return Integer.MIN_VALUE;
			if(divisor == -1)
				return Integer.MAX_VALUE;
			dividend += Math.abs(divisor);
			res += 1;
		}
		if (divisor == Integer.MIN_VALUE)
			return res;
		boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int shiftCnt = 0;
		while(divisor <= (dividend>>1)){
			divisor <<= 1;
			shiftCnt++;
		}
		while(shiftCnt >= 0){
			if(dividend >= divisor){
				res += (1 << shiftCnt);
				dividend -= divisor;
			}
			divisor >>= 1;
			shiftCnt--;
		}
		return isNeg ? -res : res;
	}

	// O(n)
	public int divide2(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			res++;
			dividend += Math.abs(divisor);
		}
		if (divisor == Integer.MIN_VALUE) {
			return res;
		}
		boolean isNeg = ((dividend ^ divisor) & 0x80000000) == 0x80000000 ? true
				: false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while (dividend >= divisor) {
			res++;
			dividend -= divisor;
		}
		return isNeg ? -res : res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution029().divide(Integer.MIN_VALUE, -1));
	}
}
