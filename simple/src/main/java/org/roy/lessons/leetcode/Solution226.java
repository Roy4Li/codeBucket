package org.roy.lessons.leetcode;

/**
 * {@literal https://leetcode.com/problems/invert-binary-tree/}
 */
public class Solution226 {


    public static void main(String[] args) {
        Solution226 instance = new Solution226();
        TreeNode tnRoot = new TreeNode(4);
        TreeNode l1 = new TreeNode(2);
        TreeNode l1l1 = new TreeNode(1);
        TreeNode l1r1 = new TreeNode(3);
        l1.left = l1l1;
        l1.right = l1r1;

        tnRoot.left = new TreeNode(1);
        instance.preOrderTraverse(tnRoot);
        instance.inOrderTraverse(tnRoot);
        instance.postOrderTraverse(tnRoot);

        System.out.println("-------");
        TreeNode newT = instance.invertBinaryTree(tnRoot);
        instance.preOrderTraverse(newT);
    }

    private TreeNode invertBinaryTree(TreeNode rootNode) {
        invertBTreeInternal(rootNode);
        return rootNode;
    }

    private void invertBTreeInternal(TreeNode rootNode) {
        if (rootNode != null) {
            invertBTreeInternal(rootNode.left);
            invertBTreeInternal(rootNode.right);
        }
        switchLeftAndRight(rootNode);
    }

    private void switchLeftAndRight(TreeNode rootNode) {
        if (rootNode != null) {
            TreeNode tmp = rootNode.left;
            rootNode.left = rootNode.right;
            rootNode.right = tmp;
        }
    }

    // 前序遍历
    private void preOrderTraverse(TreeNode root) {
        if (root == null) {
            System.out.println("null,");
            return;
        }
        System.out.println(root.val + ",");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    // 中序遍历
    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            System.out.println("null,");
            return;
        }
        inOrderTraverse(root.left);
        System.out.println(root.val);
        inOrderTraverse(root.right);
    }

    // 后序遍历
    private void postOrderTraverse(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        inOrderTraverse(root.left);
        inOrderTraverse(root.right);
        System.out.println(root.val);
    }

    private void traverseInFrontOrder(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.println("root=" + rootNode.val + ",");
        if (rootNode.left != null || rootNode.right != null) {
            System.out.println("left=" + (rootNode.left == null ? "null" : rootNode.left.val));
            System.out.println(",right=" + (rootNode.right == null ? "null" : rootNode.right.val));
            traverseInFrontOrder(rootNode.left);
            traverseInFrontOrder(rootNode.right);
        }
    }


    private void traverseInBackOrder(TreeNode rootNode) {

    }

    private void traverseInMiddleOrder(TreeNode rootNode) {

    }
}