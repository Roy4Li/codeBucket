package org.roy.lessons.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths/submissions/
 * 简单的DP问题
 */
public class Solution62_UniquePaths_DP {

    // 状态定义:dp[i][j] 走到(i,j)位置的方法,与爬楼梯类似
    // 初始化: 边沿都为0
    // 状态转移: dp[i][j] 与 dp[i-1][j] 和 dp[i][j-1] 的加和
    public int uniquePaths(int m, int n) {
        // 状态定义
        int[][] dp = new int[m][n];
        // 初始化
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        // 状态转移
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
