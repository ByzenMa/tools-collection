package com.nlp.basic.tools.algorithm.chapter2;

import com.nlp.basic.tools.stdlib.MaxPQ;

public class PQExercise {

    public static void q2_4_1() {
        String in = "PRIO*R**I*T*Y***QUE***U*E";
        char[] inChars = in.toCharArray();
        MaxPQ<Character> pq = new MaxPQ<>();
        for (char c : inChars) {
            if (c == '*') {
                System.out.print(pq.delMax() + " ");
            } else {
                pq.insert(c);
            }
        }
    }

    public static void main(String[] args) {
        q2_4_1();
    }
}
