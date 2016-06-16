package org.roy.lessons.LeetCode;

public class Solution024 {

	public ListNode swapPairs(ListNode head) {
		ListNode lastTail=null, nextHead=null, tmp=null;
		ListNode ret = head;
		while (head != null && head.next != null) {
			nextHead = head.next.next;
			tmp = head.next;
			if(lastTail != null){
				lastTail.next = tmp;
			} else {
				ret = tmp;
			}
			tmp.next = head;
			head.next = nextHead;
			lastTail = head;
			head = nextHead;
		}
		return ret;
	}
	
	private static String showList(ListNode head){
		StringBuilder s = new StringBuilder();
		s.append("[");
		if(head == null){
			s.append("]");
			return s.toString();
		}
		s.append(head.val);
		head = head.next;
		while(head != null){
			s.append("->"+head.val);
			head = head.next;
		}
		s.append("]");
		return s.toString();
	}
	
	private static ListNode createList(int[] arr){
		if(arr == null || arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode tmp = head;
		for(int i=1;i<arr.length;i++){
			tmp.next = new ListNode(arr[i]);
			tmp = tmp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(showList(createList(arr)));
		Solution024 ins = new Solution024();
		System.out.println(showList(ins.swapPairs(createList(arr))));
	}
}
