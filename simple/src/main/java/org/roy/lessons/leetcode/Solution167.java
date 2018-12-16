package org.roy.lessons.leetcode;

import com.google.common.collect.Lists;

/**
 * Level:  Easy
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * {@literal https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/}
 */
public class Solution167 {

    public int[] twoSum_1(int[] numbers, int target) {
        int t = numbers.length - 1; // tail
        for (int h = 0; h < t; ) {
            int sum = numbers[h] + numbers[t];
            if(sum == target){
                return new int[]{h+1,t+1};
            }
            if(sum < target){
                h++;
            } else {
                t--;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Solution167 instance = new Solution167();
        int[] nums = new int[]{2, 3, 5, 7, 9};
        int target = 12;
        int[] retIndex = instance.twoSum_1(nums, target);
        System.out.println("retIndex=" + Lists.newArrayList(retIndex));
        System.out.println("equal=" + (nums[retIndex[0]-1] + nums[retIndex[1]-1] == target));
    }
}