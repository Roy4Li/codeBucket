package org.roy.lessons.leetcode;

import com.google.common.base.Preconditions;

/**
 * {@literal https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/}
 * BST,Binary Search Tree
 */

public class Solution235 {


    public static void main(String[] args) {
        Solution235 instance = new Solution235();
        TreeNode root = init();
        TreeNode case1 = instance.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println("case1=" + case1.val);
        Preconditions.checkArgument(case1.val == 6);

        TreeNode case2 = instance.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println("case2=" + case2.val);
        Preconditions.checkArgument(case2.val == 2);
    }

    private static TreeNode init() {
        TreeNode root = new TreeNode(6).withLeft(2).withRight(8);
        root.left.withLeft(0).withRight(4);
        root.right.withLeft(7).withRight(9);
        root.left.right.withLeft(3).withRight(5);
        return root;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isRoot(root, p, q)) {
            return root;
        }
        if (isBothOnLeftSide(root, p, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (isBothOnRightSide(root, p, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        throw new IllegalArgumentException("");
    }

    private boolean isRoot(TreeNode root, TreeNode p, TreeNode q) {
        return p.val <= root.val && root.val <= q.val
                || q.val <= root.val && root.val <= p.val;
    }

    private boolean isBothOnLeftSide(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < root.val && q.val < root.val;
    }

    private boolean isBothOnRightSide(TreeNode root, TreeNode p, TreeNode q) {
        return p.val > root.val && q.val > root.val;
    }

}