package org.roy.lessons.LeetCode;

public class Solution100 {
	
	  // Definition for binary tree
	  public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	 
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		else if(p == null || q == null)
			return false;
		else{
			if(p.val != q.val)
				return false;
			else
				return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}
	}

	public static void main(String[] args) {
		Solution100 instance = new Solution100();
		System.out.println("abcde");
	}
}