package org.roy.lessons.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Level: Medium
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 * todo not done yet
 * {@literal https://juejin.im/post/59e5544851882551dd311710} 具体的分析过程比较复杂，核心思路是研究出fast和slow节点第一次相遇
 * 时的算式关系
 */
public class Solution142 {


    public ListNode detectCycle_1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode f = head;
        while (f.next != null) {
            if (nodeSet.contains(f)) {
                return null;
            }
            nodeSet.add(f);
            f = f.next;
        }
        return null;
    }


    public static void main(String[] args) {
        Solution142 instance = new Solution142();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n1;

        System.out.println(instance.detectCycle_1(n1));
    }

}