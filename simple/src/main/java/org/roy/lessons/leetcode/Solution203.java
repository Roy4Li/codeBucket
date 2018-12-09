package org.roy.lessons.leetcode;

public class Solution203 {

	
	 private class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	public ListNode removeElements(ListNode head, int val) {
		ListNode curNode = head;
		ListNode lastNode = null;
		while(curNode != null){
			if(curNode.val == val){
				if(lastNode == null){ // head node 
					head = curNode.next;
				} else {
					lastNode.next = curNode.next;
				}
			} else {
				lastNode = curNode;
			}
			curNode = curNode.next;
		}
		return head;
	}

	public static void main(String[] args) {
	}
}
