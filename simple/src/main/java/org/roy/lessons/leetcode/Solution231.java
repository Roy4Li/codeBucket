package org.roy.lessons.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * {@literal https://leetcode.com/problems/power-of-two}
 */

public class Solution231 {


    public static void main(String[] args) {
        Solution231 instance = new Solution231();
        for (int i = -22; i < 100; i++) {
            System.out.println(i + ": " + instance.isPowerOfTwo_1(i));
        }
    }

    // 2的幂次方的特点,2进制显示时最高位是1,其他都是0
    // 如 1,10,100,1000,...
    // 思路:先存储,find;会用内存较多
    public boolean isPowerOfTwo_1(int n) {
        Set<Integer> matchedSet = new HashSet<>();
        for (int i = 0; i < 31; i++) { // 是31,不是32,因为最高位是符号位
            matchedSet.add(1 << i);
        }
        return matchedSet.contains(n);
    }

    // 直接移位
    public boolean isPowerOfTwo_2(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == 1 << i) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo_3(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // 通过除法
    public boolean isPowerOfTwo_4(int n) {
        if (n <= 0) {
            return false;
        }
        while (n >= 2) {
            n = n / 2;
        }
        return n == 1;
    }
}