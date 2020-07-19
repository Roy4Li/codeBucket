package org.roy.lessons.leetcode.dp;

/**
 * 爬楼梯问题,每次爬1,2级,爬到N级有多少种方法
 */
public class ClimbStairs {


    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        for (int i = 1; i < 20; i++) {
            System.out.println("i="+i+",result="+climbStairs.computeWays(i));
        }
    }

    /**
     * @param n
     * @return
     */
    public int computeWays(int n) {
        if (n <= 0) {
            return 0;
        }
        // 1级台阶,只有1种方式
        if (n == 1) {
            return 1;
        }
        // 2级台阶,有2种方式,1+1 or 2
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0; // dummy
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移: 爬到第N阶,可从N-1阶走1步,或者从N-2阶走2步
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
