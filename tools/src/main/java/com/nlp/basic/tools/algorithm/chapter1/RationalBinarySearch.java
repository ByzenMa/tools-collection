package com.nlp.basic.tools.algorithm.chapter1;

import java.util.Arrays;

public class RationalBinarySearch {
    private int N;
    private double[] a;

    public RationalBinarySearch(double[] keys, int N) {
        a = new double[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
        this.N = N;
    }

    public int rank(double r) {
        return rank(r, 0, a.length - 1);
    }

    private int rank(double r, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (Math.abs(r - a[mid]) < (1.0 / (N * N))) return mid;
        if (a[mid] > r) return rank(r, lo, mid - 1);
        if (a[mid] < r) return rank(r, mid + 1, hi);
        return -1;
    }

    public static void main(String[] args) {
        double[] a = {1.0 / 4, 1.0 / 3, 3.0 / 4, 2.0 / 3, 1.0 / 6, 2.0 / 7, 5.0 / 7, 1.0 / 9};
        RationalBinarySearch test = new RationalBinarySearch(a, 10);
        System.out.println(test.rank(2.0 / 7));
        System.out.println(test.rank(3.0 / 7));
    }
}
