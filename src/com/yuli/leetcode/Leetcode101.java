package com.yuli.leetcode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * 两种解法 使用递归比较左节点的左孩子和右节点的右孩子以及左节点的右孩子和右节点的左孩子
 * 使用队列，进行两辆比较，每次放进去两个节点，并且分别比较两个节点的左右两个子节点
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root == null || (left == null && right == null)) {
            return true;
        }

        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            //如果都为空就跳过，说明相等
            if (left == null && right == null) {
                continue;
            }
            //如果有一个不为空就时false
            if (left == null || right == null) {
                return false;
            }
            //如果值不相等就false
            if (left.val != right.val) {
                return false;
            }
            //将相对的两个节点放进队列
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(right.left);
            queue.offer(left.right);
        }
        return true;
    }

    /**
     * 递归
     *
     * @param left
     * @param right
     * @return
     */
    boolean deepCheck(TreeNode left, TreeNode right) {
        //如果左右子树都为空，就返回ture
        if (left == null && right == null) {
            return true;
        }
        //如果有一个不为空，就说明不对称
        if (left == null || right == null) {
            return false;
        }

        //值不相等返回false
        if (left.val != right.val) {
            return false;
        }
        /**
         * 递归比较左节点的左孩子和右节点的右孩子
         * 左节点的右孩子和右节点的右孩子
         */
        return deepCheck(left.left, right.right) && deepCheck(left.right, right.left);
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
