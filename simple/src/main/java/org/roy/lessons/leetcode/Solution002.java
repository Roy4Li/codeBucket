package org.roy.lessons.leetcode;

public class Solution002 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null,cur=null;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0){
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;
			int sum = l1Val + l2Val + carry;
			if(sum >= 10){
				carry = 1;
				sum -= 10;
			} else 
				carry = 0;
			if(head == null){
				head = new ListNode(sum);
				cur = head;
			} else {
				cur.next = new ListNode(sum);
				cur = cur.next;
			}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return head;
	}

	public static void main(String[] args) {

	}

}
