package org.roy.lessons.leetcode;

import java.util.*;

public class Solution018 {

	class MyArray {
		private int i, j, k;

		MyArray(int a, int b, int c) {
			this.i = a;
			this.j = b;
			this.k = c;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MyArray) {
				MyArray l = (MyArray) obj;
				return l.i == this.i && l.j == this.j && l.k == this.k;
			}
			return false;
		}

		@Override
		public int hashCode() {
			int ret = 17;
			ret = ret * 31 + i;
			ret = ret * 31 + j;
			ret = ret * 31 + k;
			return ret;
		}
	}
	
	private  Map<MyArray, Integer> resultMap = new HashMap<MyArray, Integer>();

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int k = j + 1;
				int l = nums.length - 1;
				int newT = target - nums[i] - nums[j];
				while (k < l) {
					if (nums[k] + nums[l] == newT) {
						if (!containes(nums[i], nums[j], nums[k], nums[l])) {
							ret.add(Arrays.asList(nums[i], nums[j], nums[k],
									nums[l]));
							put(nums[i], nums[j], nums[k], nums[l]);
						}
						k++;
						l--;
					} else if (nums[k] + nums[l] > newT) {
						l--;
					} else {
						k++;
					}
				}
			}
		}
		return ret;
	}

	public void put(int i, int j, int k, int l) {
		resultMap.put(new MyArray(i, j, k), l);
	}

	public boolean containes(int i, int j, int k, int l) {
		MyArray key = new MyArray(i,j,k);
		return resultMap.containsKey(key) && resultMap.get(new MyArray(i, j, k)) == l;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, -1, -2, -2, 2, 0, -2, 2 };
		int target = 0;
		System.out.println(new Solution018().fourSum(nums, target));
	}
}
