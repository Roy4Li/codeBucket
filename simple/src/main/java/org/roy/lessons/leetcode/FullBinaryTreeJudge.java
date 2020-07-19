package org.roy.lessons.leetcode;

/**
 * 满二叉树判定
 * 判定一棵树是否为满二叉树
 */
public class FullBinaryTreeJudge {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.withLeft(3);
        FullBinaryTreeJudge instance = new FullBinaryTreeJudge();

        instance.isFBT(root);
        root.withRight(4);
        instance.isFBT(root);
    }

    private Integer total = 0;

    public boolean isFBT(TreeNode root) {
        // 思路: 2^深度-1 == total
        int height = height(root);
        System.out.println("height="+height);
        total = 0;
        countTotal(root);
        System.out.println("total="+total);
        boolean result=  total == Math.pow(2,height) - 1;
        System.out.println("result="+result);
        return result;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lH = height(root.left);
        int rH = height(root.right);
        return Math.max(lH, rH) + 1;
    }

    private void countTotal(TreeNode root) {
        // 前序遍历
        if (root != null) {
            total += 1;
            countTotal(root.left);
            countTotal(root.right);
        }
    }
}
