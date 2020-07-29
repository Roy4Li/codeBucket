package org.roy.lessons.leetcode;

import java.util.*;

public class Solution001 {


	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		// store duplicate values
		Map<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]))
				map2.put(nums[i], i + 1);
			else
				map.put(nums[i], i + 1);
		}
		int index1 = 0, index2 = 0;
		for (int i : map.keySet()) {
			index1 = map.get(i);
			if (i == target - i) {
				if (map2.containsKey(target - i)) {
					index2 = map2.get(target - i);
					break;
				}
			} else if (map.containsKey(target - i)) {
				index2 = map.get(target - i);
				break;
			}
		}
		return new int[] { index1, index2 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
