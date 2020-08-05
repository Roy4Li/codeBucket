package org.roy.lessons.temp;

import org.roy.lessons.leetcode.TreeNode;

import java.util.Stack;

/**
 * 非递归遍历二叉树
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.withLeft(11);
        root.withRight(21);
        root.left.withRight(112);
        root.left.right.withRight(1122);

//        middleOrderRecursive(root);
//        System.out.println("非递归:");
//        middleOrderNonRecursive(root);

        preOrderRecursive(root);
        System.out.println("非递归:");
        preOrderNonRecursive(root);
    }


    // 前序遍历: 递归
    public static void preOrderRecursive(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // 前序遍历,非递归
    public static void preOrderNonRecursive(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;

        while (p != null || !stack.empty()) {
            // 访问当前节点,若有左节点
            while (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            // 此时stack的top节点 无左节点,且本身已遍历过,移动到右子树
            if (!stack.empty()) {
                p = stack.pop().right;
            }
        }
    }

    // 中序遍历: 递归
    public static void middleOrderRecursive(TreeNode root) {
        if (root != null) {
            // 左子树
            middleOrderRecursive(root.left);
            System.out.println(root.val);
            middleOrderRecursive(root.right);
        }
    }

    // 中序遍历: 非递归
    public static void middleOrderNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            // 当前节点有左节点,则当前节点暂存稍后处理
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 此时 stack的top节点的左子树为null,打印之,并移动到右子树
            if (!stack.empty()) {
                TreeNode top = stack.peek();
                System.out.println(top.val);
                stack.pop();
                p = top.right;
            }
        }
    }

}
