package org.roy.lessons.leetcode;


public class Solution110 {

	// use recursion
	public int getHeight(TreeNode root){
		if(root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
 		return Math.max(leftHeight, rightHeight) + 1;
 	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		if(isBalanced(root.left) && isBalanced(root.right)){
			int left = getHeight(root.left);
			int right = getHeight(root.right);
			return Math.abs(left - right) <= 1;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution110 instance = new Solution110();
		System.out.println();
	}
}