package org.roy.lessons.leetcode;

public class Solution198 {

	public int rob(int[] nums) {
		
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1) {
			return nums[0];
		} else {
			int[] maxV = new int[nums.length];
			maxV[0] = nums[0];
			maxV[1] = Math.max(maxV[0], nums[1]);
			for (int i = 2; i < nums.length; i++) {
				maxV[i] = Math.max(maxV[i - 2] + nums[i], maxV[i - 1]);
			}
			return maxV[nums.length-1];
		}
	}

	public static void main(String[] args) {
	}
}
