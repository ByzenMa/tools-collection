package com.nlp.basic.tools.algorithm.chapter2;

public class UnorderedArrayMaxPQ {

    private int[] pq;
    private int n;

    public UnorderedArrayMaxPQ(int initCapacity) {
        pq = new int[initCapacity + 1];
        n = 0;
    }

    public void insert(int a) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = a;
    }

    private void resize(int i) {
        int[] temp = new int[i];
        for (int k = 0; k < pq.length; k++) {
            temp[k] = pq[i];
        }
        pq = temp;
    }

    public int delete() {
        int max = 1;
        for (int k = 2; k < pq.length; k++) {
            if (pq[k] > pq[max]) max = k;
        }
        int temp = pq[max];
        pq[max] = pq[n];
        pq[n--] = 0;
        return temp;
    }
}
