package com.nlp.basic.tools.algorithm.chapter2;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public OrderedArrayMaxPQ(int initCapacity) {
        pq = (Key[]) (new Comparable[initCapacity + 1]);
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Key delMax() {
        return pq[n--];
    }

    public void insert(Key item) {
        pq[++n] = item;
        int i;
        for(i=n;i>1&&item.compareTo(pq[i-1])<0;i--){
            pq[i] = pq[i-1];
        }
        pq[i] = item;
    }

    public static void main(String[] args) {
        String in = "PRIO*R**I*T*Y***QUE***U*E";
        char[] inChars = in.toCharArray();
        OrderedArrayMaxPQ pq = new OrderedArrayMaxPQ(30);
        for (char c : inChars) {
            if (c == '*') {
                System.out.print((char) pq.delMax() + " ");
            } else {
                pq.insert(c);
            }
        }
    }
}
