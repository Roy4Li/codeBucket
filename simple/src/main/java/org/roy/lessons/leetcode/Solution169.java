package org.roy.lessons.leetcode;


public class Solution169 {
	/* 
	 * Given an array of size n, find the majority element. 
	 * The majority element is the element that appears more than  (n/2) times.
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 */
	public int majorityElement(int[] num) {
		int candidate = 0,nTimes = 0;
		for(int i=0;i<num.length;i++){
			if(nTimes == 0){
				candidate = num[i];
				nTimes = 1;
			} else {
				if(candidate == num[i])
					nTimes++;
				else
					nTimes--;
			}
		}
		return candidate;
	}
	
	public static void main(String[] args) {
		int[] ai = {3,3,4,4,5,6,3,3,3,3,3,3};
		Solution169 a = new Solution169();
		System.out.println(a.majorityElement(ai));
	}

}
