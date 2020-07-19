package org.roy.lessons.leetcode.dp;

/**
 * 最大连续子数组
 * 问题: 序列 {1,2,3,-4,-6},求最大连续子序列的和
 */
public class MaxArrNum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -5, 3, 7, 9};
        System.out.println("result=" + maxArrNum(nums));
    }


    public static int maxArrNum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 状态定义:maxSum[i]为以i项结尾的最大子序列的和
        int[] maxSum = new int[nums.length];
        // 状态初始化
        maxSum[0] = nums[0];
        // 最大值
        int maxV = maxSum[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态转移,若加上后递增,则增大,否则,重新累加
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
            if (maxV < maxSum[i]) {
                maxV = maxSum[i];
            }
        }
        return maxV;
    }
}
