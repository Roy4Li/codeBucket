package org.roy.lessons.leetcode;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class Solution344 {

    public static void main(String[] args) {
        char[] charArray = {'h','e','l','l','o','3'};
        new Solution344().reverseString(charArray);
        System.out.println(charArray);
    }

    // in place 反转
    // 首尾index,交互
    public void reverseString(char[] s) {
        for (int head = 0,tail = s.length - 1;head < tail ;){
            char headChar = s[head];
            // swap
            s[head] = s[tail];
            s[tail] = headChar;
            head++;
            tail--;
        }
    }
}
