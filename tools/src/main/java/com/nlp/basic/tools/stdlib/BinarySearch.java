package com.nlp.basic.tools.stdlib;

import java.util.Arrays;

/**
 * 该类用于对已排序的文件查找指定的整数
 * Created by mabaizhang on 2017/7/2.
 */
public class BinarySearch {
    /**
     * 私有化初始化方法，对于静态方法，均通过static调用
     */
    private BinarySearch() {
    }

    /**
     * 二分查找指定整数
     *
     * @param a
     * @param key
     * @return
     */
    public static int indexof(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexof(whitelist, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}
