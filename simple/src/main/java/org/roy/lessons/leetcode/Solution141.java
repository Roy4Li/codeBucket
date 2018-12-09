package org.roy.lessons.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Level: Easy
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 * {@literal https://leetcode.com/problems/single-number/}
 */
public class Solution136 {


    public int findSingle_1(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("wrong input");
        }
        if (nums.length < 2) {
            return nums[0];
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isSingle = true;
            if(hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    isSingle = false;
                    break;
                }
            }
            if (isSingle) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("not found");
    }

    public int findSingle_2(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution136 instance = new Solution136();
        int[] intArr = new int[]{
                2,2,1
        };
        int b1 = 0b010101;
        int b2 = 0b101010;

        System.out.println("b1 ~ b2" + (~b2));
        System.out.println(instance.findSingle_1(intArr));
        System.out.println(instance.findSingle_2(intArr));

    }
}