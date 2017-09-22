package com.nlp.basic.tools.algorithm.chapter2;

public class RecursiveSelect {

    public static void sort(int[] in) {
        sort(in, 0);
    }

    private static void sort(int[] in, int i) {
        if (i == in.length - 1) return;
        int min = i;
        for(int k=i+1;k<in.length;k++) {
            if(in[k]<in[min]) {
                min = k;
            }
        }

        exch(in, min ,i);
        sort(in, i+1);
    }

    private static void exch(int[] in, int min, int i) {
        int tmp = in[min];
        in[min] = in[i];
        in[i] = tmp;
    }


    public static void main(String[] args) {

        int[] in = {1, 2, 3, 1, 2, 3, 1, 24, 3, 1, 12, 3, 5};
        sort(in);
        for (int e : in) {
            System.out.print(e + " ");
        }
    }
}
