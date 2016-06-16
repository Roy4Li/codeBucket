package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution206 {
	// Definition for singly-linked list
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode last, cur,next;
		last = head;
		cur = head.next;
		last.next = null;
		while(cur != null){
			next = cur.next;
			cur.next = last;
			last = cur;
			cur = next;
		}
		return last;
	}

	public static void main(String[] args) {
	}
}
