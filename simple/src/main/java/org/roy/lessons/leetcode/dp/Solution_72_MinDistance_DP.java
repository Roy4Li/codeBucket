package org.roy.lessons.leetcode.dp;

public class Solution_72_MinDistance_DP {

    public int minDistance(String word1, String word2) {

        // 状态定义 dp[i][j] w1前i个字符 转换为 w2前j个字符的最小操作数
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化 空-> target ; target->空
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 状态转换,与当前字符是否相等有关
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                // 当前字符相等,则无需额外步骤
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则,要根据之前转换结果的最小值+1
                    // 左-> 删除,左上 -> 替换,上->新增,均为增加1步操作
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    private static int min(int i1, int i2, int i3) {
        return Math.min(Math.min(i1, i2), i3);
    }

}
