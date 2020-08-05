package org.roy.lessons.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution143 {

    private List<List<Integer>> result;

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,7,8,0};
        Arrays.sort(arr);
        System.out.println(arr);
//        TreeNode root = new TreeNode(1);
//        Solution143 instance = new Solution143();
//        System.out.println(instance.pathSum(root,1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList();
        result = new ArrayList<>();
        if(root != null){
            findSum(root,0,sum,path);
        }
        return result;
    }

    private void findSum(TreeNode root,int curSum,int expected,List<Integer>  curPath){
        if(root == null){
            return;
        }
        curSum += root.val;
        curPath.add(root.val);
        // 当前节点是否为叶子节点
        if(isLeaf(root) && curSum == expected){
            // 找到match的路径,加入返回结果
            List<Integer> matched = new ArrayList<>(curPath);
            result.add(matched);
        }
        findSum(root.left,curSum,expected,curPath);
        findSum(root.right,curSum,expected,curPath);
        // 退出当前节点
        curPath.remove(curPath.size() - 1);
    }

    private static boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
}
