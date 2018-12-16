package org.roy.lessons.leetcode;

import java.util.HashSet;

/**
 * Level:  Easy
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * {@literal https://leetcode.com/problems/contains-duplicate//}
 */
public class Solution217 {



    public boolean containsDuplicate_2(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int n : nums){
            if(!h.add(n)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]== nums[j]){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution217 instance = new Solution217();
        int[] nums = new int[]{1, 3, 5, 5, 9};
        boolean hasDup = instance.containsDuplicate_1(nums);
        System.out.println("hasDup=" + hasDup);
    }
}