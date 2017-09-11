package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.Stack;

public class CheckStackSeq {

    public static boolean check(String o) {
        Stack<String> s = new Stack<>();
        if (null == o || o.length() == 0) throw new NullPointerException("String is empty or null");

        int next = 0;
        for (int i = 0; i < 10; i++) {
            s.push(i + "");
            while (s.size() > 0 && next < o.length() && s.peek().equals(o.charAt(next) + "")) {
                s.pop();
                next++;
            }
        }
        return s.size() == 0;
    }


    public static void main(String[] args) {
        String o = "4321098765";
        System.out.println(check(o));
    }
}
