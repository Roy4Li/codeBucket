package org.roy.lessons.leetcode;

import java.util.*;

public class Solution102 {

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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new Vector<List<Integer> >();
		List<List<Integer> > result = new Vector<List<Integer> >();
		List<Integer> cur = new Vector<Integer>();
		Queue<NewNode> nodeQueue = new LinkedList<NewNode>();
		int lastLevel = 0;
		nodeQueue.add(new NewNode(root,0));
		while(!nodeQueue.isEmpty()){
			NewNode head = nodeQueue.poll();
			if(head.level > lastLevel){
				result.add(cur);
				cur = new Vector<Integer>(); 
				lastLevel = head.level;
			}
			cur.add(head.node.val);
			if(head.node.left != null){
				nodeQueue.offer(new NewNode(head.node.left,lastLevel+1));
			}
			if(head.node.right != null){
				nodeQueue.offer(new NewNode(head.node.right,lastLevel+1));
			}
		}
		// last level
		result.add(cur);
		return result;
	}

	public static void main(String[] args) {
		Solution102 instance = new Solution102();
		System.out.println();
	}
}