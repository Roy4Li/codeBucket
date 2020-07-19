package org.roy.lessons.leetcode.dp;

/**
 * 原题解析: https://blog.csdn.net/Moo_Lavender/article/details/103546549
 * 问题:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，够偷窃到的最高金额。
 */
public class RobHouse {

    public static void main(String[] args) {
        System.out.println(maxRob(new int[]{3,4,5,6,7,8}));
    }

    public static int maxRob(int[] moneys) {

        // 状态定义 [i][0]:不偷的和 [i][1] 偷的和
        int[][] robMoney = new int[moneys.length][2];
        // 初始化
        robMoney[0][0] = 0;
        robMoney[0][1] = moneys[0];
        // 状态转移
        for (int i = 1; i < moneys.length; i++) {
            // 第i家不偷,则 取上一家两种情况的最大值
            robMoney[i][0] = Math.max(robMoney[i - 1][0], robMoney[i - 1][1]);
            // 若偷第i家,则 上一家不能偷
            robMoney[i][1] = robMoney[i - 1][0] + moneys[i];
        }
        // 走完最后一家,选最大值
        return Math.max(robMoney[moneys.length - 1][0],
                robMoney[moneys.length - 1][1]);
    }
}
