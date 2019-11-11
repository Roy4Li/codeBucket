package org.roy.lessons.leetcode;

/**
 * {@literal https://leetcode.com/problems/move-zeroes/}
 */

public class Solution283 {


    public static void main(String[] args) {
        Solution283 instance = new Solution283();
        int[] nums = {1, 2, 0, 3, 0};
        instance.moveZeroes(nums);
        System.out.println("nums.length=" + nums.length);
    }

    public void moveZeroes(int[] nums) {
        // in place moves
        for (int i = 0; i < nums.length - 1; i++) {
            int s = nums[i];
            // i points to first zero place
            // swap ?
            // if zero continue
            for (int j = i + 1; j < nums.length; j++) {
                // if current is not zero ,just swap
                int e = nums[j];

            }
        }
    }
}