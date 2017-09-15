package com.nlp.basic.tools.algorithm.chapter1;

import java.util.Arrays;

public class StaticSETofInts {

    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }


    public boolean contains(int key) {
        return rank(key, 0, a.length - 1) != -1;
    }

    private int rank(int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return mid;
        if (a[mid] > key) return rank(key, lo, mid - 1);
        if (a[mid] < key) return rank(key, mid + 1, hi);
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 9, 11, 4, 10, 26, 24, 14, 13};
        StaticSETofInts test = new StaticSETofInts(a);
        System.out.println(test.contains(9));
        System.out.println(test.contains(19));
    }

}
