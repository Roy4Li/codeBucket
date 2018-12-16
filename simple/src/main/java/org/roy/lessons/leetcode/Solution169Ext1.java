package org.roy.lessons.leetcode;


public class Solution169Ext1 {
	/* 
	 * Given an array of size n, find the majority element. 
	 * The majority element is the element that appears more than  (n/3) times.
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 */
	public int majorityElement(int[] num) {
		int candidate1 = 0,c1Times = 0;
		int candidate2 = 0,c2Times = 0;
		for(int i=0;i<num.length;i++){
			
			if(c1Times == 0){
				candidate1 = num[i];
				c1Times = 1;
			} else if (c2Times == 0) {
				if(candidate1 == num[i])
					c1Times++;
				else {
					candidate2 = num[i];
					c2Times = 1;
				}
			} else {
				if (candidate1 == num[i])
					c1Times++;
				else if(candidate2 == num[i])
					c2Times++;
				else {
					c1Times--;
					c2Times--;
				}
			}
		}
		return c1Times > c2Times ? candidate1:candidate2;
	}
	
	public static void main(String[] args) {
		int[] ai = {3,3,4,4,5,3};
		Solution169Ext1 a = new Solution169Ext1();
		System.out.println(a.majorityElement(ai));
	}

}
