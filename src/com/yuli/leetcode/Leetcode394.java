package com.yuli.leetcode;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 采用栈来解决,将数据压入栈种来记住前面的数据
 */
public class Leetcode394 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int idx = 0;
        while (idx < s.length()) {
            char cur = s.charAt(idx);
            //处理数字
            if (Character.isDigit(cur)) {
                StringBuffer sb = new StringBuffer();

                while (Character.isDigit(s.charAt(idx))) {
                    sb.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(sb.toString()));
            } else if (cur == '[') {//处理[，将后续字符读取完成后，压入字符串栈种

                resStack.push(res);
                res = "";
                idx++;
            } else if (cur == ']') {//处理]，将字符串重复n遍
                StringBuffer sb = new StringBuffer((resStack.pop()));
                Integer times = countStack.pop();
                for (Integer i = 0; i < times; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
