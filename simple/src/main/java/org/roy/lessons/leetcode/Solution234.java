package org.roy.lessons.leetcode;

import com.google.common.collect.Lists;

import java.util.Stack;

/**
 * {@literal https://leetcode.com/problems/palindrome-linked-list/}
 */

public class Solution234 {


    public static void main(String[] args) {
        Solution234 instance = new Solution234();
        ListNode head = ListNode.buildFromList(Lists.newArrayList(1,2,2,1));
        instance.isPalindrome(head);
        System.out.println("isPalindrome=" + instance.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int size = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            size += 1;
            tmp = tmp.next;
        }
        //
        Stack<Integer> stack = new Stack<>();
        int middle = size / 2;
        boolean isOdd = size % 2 == 1;
        ListNode t2 = head;
        stack.push(t2.val);
        while (middle - 1 > 0) {
            t2 = t2.next;
            stack.push(t2.val);
            middle--;
        }
        // if odd,move to Really Middle one!
        if (isOdd) t2 = t2.next;
        // traverse the next half,and pop from stack
        while (t2.next != null) {
            t2 = t2.next;
            if (stack.pop() != t2.val) {
                return false;
            }
        }
        return true;
    }
}