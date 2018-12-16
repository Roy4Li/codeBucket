package org.roy.lessons.leetcode;


public class Solution019 {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode t = head;
	        if(head == null || head.next == null)
	        	return null;
	        int length = 1;
	        while(t.next != null){ 
	        	t = t.next;
	        	length++;
	        }
	        if(length == n) // head node
	        	return head.next;
	        // not the head node
	        t = head;
	        while(length - n > 1){
	        	t = t.next;
	        	length--;
	        }
	        t.next = t.next.next;
	        return head;
	    }
	}
	public static void main(String[] args) {
		Solution019 a = new Solution019();
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
