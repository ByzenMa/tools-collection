package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.Stack;

public class Parentheses {

    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> seq = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT_PAREN) {
                seq.push(s.charAt(i));
            }

            if (c == LEFT_BRACE) {
                seq.push(s.charAt(i));
            }

            if (c == LEFT_BRACKET) {
                seq.push(s.charAt(i));
            }

            if (c == RIGHT_PAREN) {
                if (seq.pop() != LEFT_PAREN) {
                    return false;
                }
            }

            if (c == RIGHT_BRACE) {
                if (seq.pop() != LEFT_BRACE) {
                    return false;
                }
            }

            if (c == RIGHT_BRACKET) {
                if (seq.pop() != LEFT_BRACKET) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        System.out.println(isBalanced(s));

        s = "[(])";
        System.out.println(isBalanced(s));
    }

}
