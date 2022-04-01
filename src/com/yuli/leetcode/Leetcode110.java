package com.yuli.leetcode;

/**
 * 110. 平衡二叉树
 */
public class Leetcode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }
    private int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        //从叶子节点递归返回高度
        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right)>1) {
            return -1;
        }
        //返回左右子树种最大的深度
        return Math.max(left,right) + 1;
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
