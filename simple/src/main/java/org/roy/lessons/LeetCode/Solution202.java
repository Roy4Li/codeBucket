package org.roy.lessons.LeetCode;

import java.util.Hashtable;

public class Solution202 {

	public boolean isHappy(int n) {
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		while(true){
			char[] digits = new Integer(n).toString().toCharArray();
			int squareSum = 0;
			for(char c:digits){
				squareSum += Math.pow(c-'0', 2);
			}
			if(squareSum == 1)
				return true;
			if(ht.containsKey(squareSum))
				return false;
			else
				ht.put(squareSum, 1);
			n = squareSum;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution202().isHappy(19));
	}
}
