package com.yuli.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 先访问左节点，如果为空就访问自己，在访问右节点
 * 1、通过递归
 * 2、使用栈，先把左子树压栈直到没有左子树，然后出栈访问，然后把root设置为右节点
 */
public class Leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    private List<Integer> inorderTraversalWithLoop(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            //一直往做循环，把节点放入栈种，直到找到最左边的子树
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            //确定没有左子树后取出节点值
            root = stack.pop();
            res.add(root.val);
            root= root.right;
        }
        return res;
    }

    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        accessTree(root.left, res);
        res.add(root.val);
        accessTree(root.right, res);
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
