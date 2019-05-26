package org.roy.lessons.leetcode;

import com.google.common.collect.Lists;

/**
 * {@literal https://leetcode.com/problems/delete-node-in-a-linked-list/}
 */

public class Solution237 {


    public static void main(String[] args) {
        Solution237 instance = new Solution237();
        ListNode listNode = ListNode.buildFromList(Lists.newArrayList(4, 5, 1, 9));
        instance.deleteNode(listNode);
    }

    public void deleteNode(ListNode node) {
        // copy next to current,next never be null
        ListNode next = node.next;
        node.val = next.val;
        // set pointer to the next.next
        node.next = next.next;
    }

}