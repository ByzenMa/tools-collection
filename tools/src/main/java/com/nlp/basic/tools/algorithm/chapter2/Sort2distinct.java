package com.nlp.basic.tools.algorithm.chapter2;

public class Sort2distinct {

    private static int key1 = 1;
    private static int key2 = 2;

    public static void sort2distinct(int[] a) {
        int i = -1, j = a.length;

        while (true) {
            while (a[++i] == key1) if (i == a.length - 1) break;
            while (a[--j] == key2) if (j == 0) break;
            if (i >= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2};
        sort2distinct(a);
        for (int e : a) {
            System.out.print(e + " ");
        }
    }
}
