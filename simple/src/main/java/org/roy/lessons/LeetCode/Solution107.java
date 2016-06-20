package org.roy.lessons.LeetCode;

import java.util.*;

public class Solution107 {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class NewNode {
		TreeNode node;
		int level;

		NewNode(TreeNode m, int l) {
			node = m;
			level = l;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return new Vector<List<Integer>>();
		
		
		Queue<NewNode> nodeQueue = new LinkedList<NewNode>();
		Vector<Integer> cur = new Vector<Integer>();
		Stack<Vector<Integer>> retStack = new Stack<Vector<Integer>>();
		int lastLevel = 0;
		nodeQueue.offer(new NewNode(root,0));
		while (!nodeQueue.isEmpty()) {
			NewNode head = nodeQueue.poll();
			if (head.level > lastLevel) {
				retStack.push(cur);
				cur = new Vector<Integer>();
				lastLevel = head.level;
			}
			cur.add(head.node.val);
			if (head.node.left != null) {
				nodeQueue.offer(new NewNode(head.node.left, lastLevel + 1));
			}
			if (head.node.right != null) {
				nodeQueue.offer(new NewNode(head.node.right, lastLevel + 1));
			}
		}
		retStack.push(cur);
		List<List<Integer>> ret = new Vector<List<Integer>>();
		while (!retStack.isEmpty()) {
			ret.add(retStack.pop());
		}
		return ret;
	}
	
	// strategy 2 : use recursion
	public List<List<Integer> > result = new Vector<List<Integer> >();
	public void levelTraversal(TreeNode root,int level){
		if(root == null)
			return;
		if(level == result.size()){
			result.add(new Vector<Integer>());
		}
		result.get(level).add(root.val);
		levelTraversal(root.left,level+1);
		levelTraversal(root.right,level+1);
	}
	
	public List<List<Integer>> levelOrderBottom2(TreeNode root){
		levelTraversal(root,0);
		List<List<Integer>> ret = new Vector<List<Integer>>();
		for(int i=result.size();i>0;i--){
			ret.add(result.get(i-1));
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution107 instance = new Solution107();
		System.out.println();
	}
}