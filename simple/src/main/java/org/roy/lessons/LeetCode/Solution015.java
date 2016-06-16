package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution015 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); // non-descending order is ensured
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			// skip duplicate
			while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
				i++;
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				// find one triplet
				if (sum == 0) {
					List<Integer> triplet = new ArrayList<Integer>(3);
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					triplet.add(nums[k]);
					ret.add(triplet);
					j++;
					// skip duplicate
					while (j < k && nums[j] == nums[j - 1])
						j++;
					k--;
					// skip duplicate
					while (k > j && nums[k] == nums[k + 1])
						k--;
				} else if (sum > 0) {
					k--;
					while (k > j && nums[k] == nums[k + 1])
						k--;
				} else {
					j++;
					// skip duplicate
					while (j < k && nums[j] == nums[j - 1])
						j++;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
