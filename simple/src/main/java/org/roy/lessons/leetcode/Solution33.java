package org.roy.lessons.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution33 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 0};
        int result = new Solution33().search(nums, 3);
        System.out.println("result=" + result);
    }

    // 要求是O(logN)
    // 思路: 二分查找法
    public int search(int[] nums, int target) {
        // O(N)算法是遍历
        // O(logN)算法是二分查找


        return -1;
    }

}
