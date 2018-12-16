package org.roy.lessons.leetcode;

public class Solution083 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode ret = head;
		while (head != null && head.next != null) {
			int currentVal = head.val;
			int nextVal = head.next.val;
			if (currentVal == nextVal)
				head.next = head.next.next;
			else
				head = head.next;
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution083 instance = new Solution083();
		System.out.println();
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}