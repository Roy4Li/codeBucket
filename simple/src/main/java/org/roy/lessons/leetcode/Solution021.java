package org.roy.lessons.leetcode;


public class Solution021 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(-1);
		ListNode tail = newHead;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		if(l1 != null){
			tail.next = l1;
		}
		if(l2 != null){
			tail.next = l2;
		}
		return newHead.next;
	}

	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		
		Solution021 a = new Solution021();
		System.out.println();
	}
}
