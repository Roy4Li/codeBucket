package org.roy.lessons.leetcode;


public class Solution160 {

	// Definition for singly-linked list
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		int lenA = 1,lenB = 1;
		ListNode curA = headA;
		ListNode curB = headB;
		while(curA.next != null){
			lenA++;
			curA = curA.next;
		} // now curA points to the tail of A
		
		while(curB.next != null){
			lenB++;
			curB = curB.next;
		}  // now curB points to the tail of B
		
		// different tail node means no intersection
		if(curA != curB)
			return null;
		else { // intersection exists!
			int diff = lenA - lenB;
			// align
			if(diff >= 0){ // A go 
				for(int i=0;i<diff;i++){
					headA = headA.next;
				}
			}else{
				for(int i=0;i<-diff;i++){
					headB = headB.next;
				}
			}
			// find the intersection node
			while(true){
				if(headA == headB)
					return headA;
				else{
					headA = headA.next;
					headB = headB.next;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution160 instance = new Solution160();
		System.out.println();
	}
}