package org.roy.lessons.leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class Solution43 {


    public static void main(String[] args) {
        String result = new Solution43().multiply("25", "25");
        System.out.println(result); // 625
    }

    // 78
    // 45
    // 思路1:乘法改为加法计算
    public String multiply(String num1, String num2) {
        // 结果数组
        int[] result = new int[num1.length() + num2.length()];
        // 外层循环,从最后一位开始
        for (int i = num1.length() - 1; i >= 0; i--) {
            // 内存循环,
            for (int j = num2.length() - 1; j >= 0; j--) {
                int pOne = i + j + 1;
                int pTen = i + j;
                int multiResult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 本次迭代需plus上次的进位值
                int sum = multiResult + result[pOne];
                result[pTen] += sum / 10;
                result[pOne] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            // 去除前面的零
            if (sb.length() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        // corner case,结果为0
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
