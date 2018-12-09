package org.roy.lessons.leetcode;

import java.util.*;


public class Solution104 {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public class NewNode{
		TreeNode node;
		int level;
		NewNode(TreeNode m,int l){
			node = m;
			level = l;
		}
	}
	
	public int maxDepth1(TreeNode root) {
		if(root == null) return 0;
		Queue<NewNode> nodeQueue = new LinkedList<NewNode>();
		nodeQueue.offer(new NewNode(root,0));
		int lastLevel = 1;
		while(!nodeQueue.isEmpty()){
			NewNode head = nodeQueue.poll();
			if(head.level > lastLevel){
				lastLevel = head.level;
			}
			if(head.node.left != null){
				nodeQueue.add(new NewNode(head.node.left,lastLevel+1));
			}
			if(head.node.right != null){
				nodeQueue.add(new NewNode(head.node.right,lastLevel+1));
			}
		}
		return lastLevel;
	}
	
	// another strategy,maxDepth = DepthOfsubTree + 1
	public int getDepth(TreeNode root,int originalDepth){
		if(root == null)
			return originalDepth;
		else
			return 1+Math.max(getDepth(root.left,originalDepth), getDepth(root.right,originalDepth));
	}
	
	
	public int maxDepth(TreeNode root){
		return getDepth(root,0);
	}
	
	public static void main(String[] args) {
		Solution104 instance = new Solution104();
		System.out.println();
	}
}