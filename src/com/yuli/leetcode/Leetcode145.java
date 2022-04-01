package com.yuli.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return inorderTraversalWithLoop(root);
    }

    private List<Integer> inorderTraversalWithLoop(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevAccess = null;//记录上一次访问的右节点
        while (root != null || !stack.isEmpty()) {//如果根节点不为空或者栈不为空就循环
            //一直往做循环，把节点放入栈种，直到找到最左边的子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //确定没有左子树后取出节点值
            root = stack.pop();
            /**
             * 如果根节点的右子树为空，或者根节点的右子树已经被访问过了，就把根节点放进结果里
             */
            if (root.right == null || root.right == prevAccess) {
                res.add(root.val);
                prevAccess = root;//记录这个根节点已经被访问过了
                root = null;//把根节点职位空
            } else {
                stack.push(root);//如果当前根节点有右子树，就重新放进栈里
                root = root.right;//把根节点记录下来，去找根节点的左子树
            }
        }
        return res;
    }

    private void accessTree(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        accessTree(root.left, res);
        accessTree(root.right, res);
        res.add(root.val);
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
