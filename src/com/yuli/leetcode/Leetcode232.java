package com.yuli.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 采用双栈，分为输入栈和输出栈，输出的时候将输入栈数据导往输出栈
 */
public class Leetcode232 {
    private static Stack<Integer> inStack;
    private static Stack<Integer> outStack;

    public Leetcode232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        //如果输入栈不等于空，就把输入站的数据给输出栈
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
