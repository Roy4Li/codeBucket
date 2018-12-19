package org.roy.lessons.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Level:  Easy
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 * <p>
 * {@literal https://leetcode.com/problems/contains-duplicate-ii}
 */
public class Solution219 {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer existedIndex = valueIndexMap.get(nums[i]);
            if (existedIndex != null && i - existedIndex <= k) {
                return true;
            }
            valueIndexMap.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args) {
        Solution219 instance = new Solution219();
        int[] nums = new int[]{1, 0, 1, 1};
        boolean hasDup = instance.containsNearbyDuplicate(nums, 1);
        System.out.println("hasDup=" + hasDup);
    }
}