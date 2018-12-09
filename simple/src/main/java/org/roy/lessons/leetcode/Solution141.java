package org.roy.lessons.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Level: Easy
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * {@literal https://leetcode.com/problems/linked-list-cycle/}
 */
public class Solution141 {

    /**
     *
     * 快慢指针法,若有环,则一定会相遇
     * @param head
     * @return
     */
    public boolean hasCycle_4(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if(fast.next == slow || fast.next.next == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public boolean hasCycle_3(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode flagNode = new ListNode(-1);
        ListNode f = head;
        while (f.next != null) {
            if (f.next == flagNode) {
                return true;
            }
            ListNode tmp = f;
            f = f.next;
            tmp.next = flagNode;
        }
        return false;
    }

    public ListNode hasCycle_2(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode f = head;
        while (f.next != null) {
            if (nodeSet.contains(f)) {
                return f;
            }
            nodeSet.add(f);
            f = f.next;
        }
        return null;
    }



    public boolean hasCycle_1(ListNode head) {
        if(head == null){
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode f = head;
        while (f.next != null) {
            if (nodeSet.contains(f)) {
                return true;
            }
            nodeSet.add(f);
            f = f.next;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution141 instance = new Solution141();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n1;

        System.out.println(instance.hasCycle_4(n1));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}