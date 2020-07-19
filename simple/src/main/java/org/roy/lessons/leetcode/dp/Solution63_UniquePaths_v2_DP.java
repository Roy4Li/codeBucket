package org.roy.lessons.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class Solution63_UniquePaths_v2_DP {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        int cnt = uniquePathsWithObstacles(obstacleGrid);
        System.out.println("cnt=" + cnt);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 状态定义 dp[i][j] 到达(i,j)的方法数,若为0表示不可能达到
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 状态初始化,注意可能为0
        boolean gotObstacleInN = false;
        for (int i = 0; i < n; i++) {
            if (!gotObstacleInN && obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
                continue;
            }
            // 若遇obstacle,后续全为0
            if (obstacleGrid[0][i] != 0) {
                gotObstacleInN = true;
            }
            if (gotObstacleInN) {
                dp[0][i] = 0;
            }
        }

        boolean gotObstacleInM = false;
        for (int i = 0; i < m; i++) {
            if (!gotObstacleInM && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
                continue;
            }
            // 若遇obstacle,后续全为0
            if (obstacleGrid[i][0] != 0) {
                gotObstacleInM = true;
            }
            if (gotObstacleInM) {
                dp[i][0] = 0;
            }
        }

        // 状态转移,形式不变;允许一个方向上的值为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 障碍点不可触达
                if (obstacleGrid[i][j] != 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
