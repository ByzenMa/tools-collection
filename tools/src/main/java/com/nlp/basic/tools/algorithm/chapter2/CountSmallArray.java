package com.nlp.basic.tools.algorithm.chapter2;

import com.nlp.basic.tools.stdlib.StdRandom;

import java.util.HashSet;

public class CountSmallArray {

    private int count0;
    private int count1;
    private int count2;

    public CountSmallArray() {
        count0 = 0;
        count1 = 0;
        count2 = 0;
    }

    public int getCount0() {
        return count0;
    }

    public int getCount1() {
        return count1;
    }

    public int getCount2() {
        return count2;
    }

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        count(lo, hi);
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (a[--j] > v) if (j == lo) break;
            if (i >= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[lo] = a[j];
        a[j] = v;
        return j;
    }

    private void count(int lo, int hi) {
        int span = hi - lo;
        if (span == 0) count0++;
        else if (span == 1) count1++;
        else if (span == 2) count2++;
    }

    public static void main(String[] args) {
        int N = 1000;
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < N) {
            int rand = StdRandom.uniform(10 * N);
            set.add(rand);
        }
        int[] a = new int[N];
        int i = 0;
        for (int e : set) {
            a[i++] = e;
        }

        CountSmallArray test = new CountSmallArray();
        test.sort(a);

        System.out.println(test.getCount0());
        System.out.println(test.getCount1());
        System.out.println(test.getCount2());
    }
}
