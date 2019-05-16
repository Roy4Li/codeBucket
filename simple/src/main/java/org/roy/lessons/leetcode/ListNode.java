package org.roy.lessons.leetcode;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    public static ListNode buildFromList(List<Integer> intList) {
        ListNode head = new ListNode(intList.get(0));
        ListNode tail = head;
        for (int i = 1; i < intList.size(); i++) {
            ListNode next = new ListNode(intList.get(i));
            tail.next = next;
            tail = next;
        }
        return head;
    }
}
