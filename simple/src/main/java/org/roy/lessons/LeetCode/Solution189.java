package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution189 {

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		List<Integer> newNums = new ArrayList<Integer>(nums.length);
		for (int i = nums.length - k; i < nums.length; i++) {
			newNums.add(nums[i]);
		}
		for (int i = 0; i < nums.length - k; i++) {
			newNums.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = newNums.get(i);
		}
	}

	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length-1-k);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length);
	}

	public void rotate3(int[] nums, int k) {
		k %= nums.length;
		List<Integer> newNums = new ArrayList<Integer>(nums.length);
		for (int i = nums.length - k; i < nums.length; i++) {
			newNums.add(nums[i]);
		}
		for (int i = 0; i < nums.length - k; i++) {
			newNums.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = newNums.get(i);
		}
	}
    // [s,e]
	public  void reverse(int[] list, int s, int e) {
		if(list == null || list.length == 0 || s>= list.length || e >= list.length)
			return;
		int element;
		for(;s<e;){
			 element = list[s];
			 list[s] = list[e];
			 list[e] = element;
			 s++;
			 e--;
		}
	}
	
	public static void main(String[] args) {

	}
}
