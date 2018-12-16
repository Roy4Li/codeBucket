package org.roy.lessons.leetcode;

import java.util.*;

public class Solution016 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int ret = nums[0] + nums[1] + nums[nums.length-1];
		for(int i=0;i<nums.length-2;i++){
			int j=i+1;
			int k=nums.length-1;
			int result;
			while(j<k){
				result = nums[i]+nums[j]+nums[k];
				if(result == target)
					return result;
				if(Math.abs(result-target) < Math.abs(ret-target))
					ret = result;
				if(result < target)
					j++;
				else
					k--;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] nums={0,2,1,-3};
		int target = 1;
		System.out.println(new Solution016().threeSumClosest(nums, target));
	}

}
