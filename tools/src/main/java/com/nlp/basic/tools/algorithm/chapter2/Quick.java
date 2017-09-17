package com.nlp.basic.tools.algorithm.chapter2;

public class Quick {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo, j = hi+1;
        while (true) {
            while (a[++i] < v) if(i==hi) break;
            while (a[--j] > v) if(j==lo) break;
            if (i>= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[lo] = a[j];
        a[j] = v;
        return j;
    }

    public static void main(String[] args) {

        int[] a = {1, 23, 4, 2};
        sort(a);

        for (int e : a) {
            System.out.print(e + " ");
        }
    }
}
