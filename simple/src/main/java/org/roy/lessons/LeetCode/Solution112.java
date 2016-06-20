package org.roy.lessons.LeetCode;

public class Solution112 {

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
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if(root.left == null && root.right == null){
			return sum == root.val;
		}else
			return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
	}

	public static void main(String[] args) {
		Solution112 instance = new Solution112();
		System.out.println();
	}
}