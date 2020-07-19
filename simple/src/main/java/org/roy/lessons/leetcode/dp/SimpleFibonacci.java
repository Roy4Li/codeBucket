package org.roy.lessons.leetcode.dp;

/**
 * 简单的斐波那契数列序列,计算第N项
 */
public class SimpleFibonacci {

    public static void main(String[] args) {
        SimpleFibonacci instance = new SimpleFibonacci();
        for (int i = 1; i < 20; i++) {
            System.out.println("i=" + i + ",result=" + instance.fibonacci(i));
        }
    }

    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        // 1,2 均为1
        if (n <= 2) {
            return 1;
        }
        // 初始化,0,1
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

}
