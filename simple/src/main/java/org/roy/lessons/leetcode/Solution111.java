package org.roy.lessons.leetcode;

public class Solution111 {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	// use recursion
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		else if(root.left == null && root.right == null)
			return 1;
		else if(root.left == null)
			return 1 + minDepth(root.right);
		else if(root.right == null)
			return 1 + minDepth(root.left);
		else
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static void main(String[] args) {
		Solution111 instance = new Solution111();
		System.out.println();
	}
}