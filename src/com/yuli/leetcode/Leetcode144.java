package com.yuli.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 先遍历根节点，在访问左子节点和右子节点
 * 1、递归：把访问放最前面
 * 2、循环：把访问放在root循环里
 */
public class Leetcode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return inorderTraversalWithLoop(root);
    }
    private List<Integer> inorderTraversalWithLoop(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            //一直往做循环，把节点放入栈种，直到找到最左边的子树
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //确定没有左子树后取出节点值
            root = stack.pop();
            root= root.right;
        }
        return res;
    }
    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        accessTree(root.left, res);
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
