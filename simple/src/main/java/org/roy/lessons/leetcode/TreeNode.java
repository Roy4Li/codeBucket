package org.roy.lessons.leetcode;

//Definition for binary tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode withLeft(int val) {
        TreeNode left = new TreeNode(val);
        this.left = left;
        return this;
    }

    public TreeNode withRight(int val) {
        TreeNode right = new TreeNode(val);
        this.right = right;
        return this;
    }

}
