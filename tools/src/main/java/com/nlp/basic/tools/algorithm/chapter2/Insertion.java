package com.nlp.basic.tools.algorithm.chapter2;

public class Insertion {

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int j = i + 1;
            int temp = a[j];
            while (temp < a[j-1] && j > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }


    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void main(String[] args) {

        int[] a = {1, 23, 4, 2, 43, 5, 1, 2, 65, 2};
        sort(a);

        for (int e:a) {
            System.out.print(e + " ");
        }

    }

}
