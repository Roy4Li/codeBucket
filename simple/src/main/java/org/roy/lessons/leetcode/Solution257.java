package org.roy.lessons.leetcode;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * {@literal https://leetcode.com/problems/binary-tree-paths/}
 */
public class Solution257 {
    private static String prefixOrder = "";

    public static void main(String[] args) {
        Solution257 instance = new Solution257();
        // case1
        TreeNode root = new TreeNode(1);
        root.withLeft(11);
        root.withRight(12);
        // 思路:
        // 二叉树的遍历,遍历过程中记录当前节点
        // 若是叶子节点,则添加到结果中
        // 否则,继续遍历
        List<String> result = instance.binaryTreePaths(root);
        Preconditions.checkArgument(result.size() == 2);
        System.out.println(result);

        instance.prefixOrder(root);
        System.out.println(prefixOrder);
    }

    private List<String> result = new ArrayList<>();

    public void prefixOrder(TreeNode root){
       // do sth on root node
        if(root.left != null){
            prefixOrder(root.left);
        }
        System.out.println(root.val);
        if(root.right != null){
            prefixOrder(root.right);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (null != root) {
            walkThisTree(root, String.valueOf(root.val));
        }
        return result;
    }

    private void walkThisTree(TreeNode currentNode, String parentPath) {
        if (null == currentNode.left
                && null == currentNode.right) {
            result.add(parentPath);
            return;
        }

        if (currentNode.left != null) {
            // do sth to left node
            walkThisTree(currentNode.left, parentPath + "->" + currentNode.left.val);
        }

        if (currentNode.right != null) {
            // do sth to right node
            walkThisTree(currentNode.right, parentPath + "->" + currentNode.right.val);
        }
    }


}
