package org.roy.lessons.LeetCode;

public class Solution101 {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return false;
		else
			return cmpSym(root.left,root.right);
	}
	
	public boolean cmpSym(TreeNode left,TreeNode right){
		if(left == null && right == null)
			return true;
		else if(left == null || right == null)
			return false;
		else {
			if(left.val != right.val)
				return false;
			else{
				return cmpSym(left.left,right.right) && cmpSym(left.right,right.left);
			}
		}
	}

	public static void main(String[] args) {
		Solution101 instance = new Solution101();
		System.out.println();
	}
}