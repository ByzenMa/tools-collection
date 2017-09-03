package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.Queue;

public class Josephus {

    public static void printJosephus(int N, int M) {
        Queue<Integer> q = new Queue<>();

        // Initiate first queue
        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }

        int kill = 1;
        while (!q.isEmpty()) {
            if (kill == M) {
                kill = 1;
                System.out.print(q.dequeue() + " ");
            } else {
                kill++;
                q.enqueue(q.dequeue());
            }
        }
    }


    public static void main(String[] args) {
        printJosephus(7, 2);
        System.out.println();
        printJosephus(8, 20);
    }
}
