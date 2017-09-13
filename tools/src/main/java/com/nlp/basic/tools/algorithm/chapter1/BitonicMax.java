package com.nlp.basic.tools.algorithm.chapter1;

import com.nlp.basic.tools.stdlib.StdOut;
import com.nlp.basic.tools.stdlib.StdRandom;

public class BitonicMax {

    static int binarySearchAsc(int[] input, int el, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (input[mid] == el) {
            return mid;
        } else if (input[mid] > el) {
            return binarySearchAsc(input, el, lo, mid - 1);
        } else {
            return binarySearchAsc(input, el, mid + 1, hi);
        }
    }

    static int binarySearchDec(int[] input, int el, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (input[mid] == el) {
            return mid;
        } else if (input[mid] < el) {
            return binarySearchDec(input, el, lo, mid - 1);
        } else {
            return binarySearchDec(input, el, mid + 1, hi);
        }
    }

    static int max(int[] input, int lo, int hi) {
        if (lo == hi) return hi;
        int mid = lo + (hi - lo) / 2;
        if (input[mid] < input[mid + 1]) return max(input, mid + 1, hi);
        if (input[mid] > input[mid + 1]) return max(input, lo, mid);
        else return mid;
    }

    static int bitonicSearch(int[] input, int el) {
        int max = max(input, 0, input.length - 1);
        if (input[max] == el) return max;
        else {
            int left = binarySearchAsc(input, el, 0, max - 1);
            if (left == -1) {
                return binarySearchDec(input, el, max + 1, input.length - 1);
            } else {
                return left;
            }
        }
    }


    // create a bitonic array of size N
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i - 1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) a[mid] = a[mid - 1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i - 1] - 1 - StdRandom.uniform(9);
        }
        return a;
    }


    public static void main(String[] args) {
        int[] a = bitonic(100000000);
        System.out.println(bitonicSearch(a, a[2]));
    }

}
