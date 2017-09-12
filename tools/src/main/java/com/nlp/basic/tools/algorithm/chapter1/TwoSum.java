package com.nlp.basic.tools.algorithm.chapter1;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static int twoSumCount(int[] sorted, int num) {

        int i = 0;
        int j = sorted.length - 1;
        int count = 0;
        while (i < j) {
            int sum = sorted[i] + sorted[j];
            if (sum == num) {
                count++;
                i++;
                j--;
            } else if (sum > num) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] a = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(twoSumCount(a, 0));
    }
}
