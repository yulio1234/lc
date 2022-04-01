package com.yuli.leetcode;

/**
 * 226. 翻转二叉树
 * 使用递归反转二叉树，
 */
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //反转左节点
        invertTree(root.left);
        //反转右节点
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
