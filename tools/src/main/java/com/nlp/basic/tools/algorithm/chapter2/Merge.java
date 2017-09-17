package com.nlp.basic.tools.algorithm.chapter2;

public class Merge {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int n = a.length;
        int[] aux = new int[n];

        for (int i = 0; i < n; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    public static void main(String[] args) {

        int[] a = {1, 23, 4, 2, 3, 1, 4, 5, 65, 34, 523, 21};
        sort(a);

        for (int e : a) {
            System.out.print(e + " ");
        }

    }

}
