package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.Stack;

public class PrintMidOrder {

    public static void printMidOrder(String s) {
        Stack<String> nums = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                ops.push(c + "");
            } else if (c == '/') {
                ops.push('/' + "");
            } else if (c == '+') {
                ops.push('+' + "");
            } else if (c == '-') {
                ops.push('-' + "");
            } else if (c == ')') {
                String op = ops.pop();
                String num1 = nums.pop();
                String num2 = nums.pop();
                nums.push('(' + num2 + op + num1 + ')');
            } else if (c == ' ') {
                continue;
            } else {
                nums.push(c + "");
            }
        }
        System.out.println(nums.pop());
    }

    public static void main(String[] args) {
        String s = "1 + 2) * 3 -4)*5-6)))";
        printMidOrder(s);
    }

}
