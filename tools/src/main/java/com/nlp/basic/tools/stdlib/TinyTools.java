package com.nlp.basic.tools.stdlib;

/**
 * Created by mabaizhang on 2017/7/6.
 */
public class TinyTools {

    /**
     * 只能显式调用
     */
    private TinyTools() {
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4};
        int m = 5;
        int[] r = histogram(a, m);
        for (int e : r) {
            StdOut.println(e);
        }
    }


    /**
     * 返回斐波拉契数列的第n个值，其中初始值从0，1开始。初始下标从0开始
     */
    public static int fibonacci(int n) {
        int f = 0;
        int g = 1;
        for (int i = 0; i < n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * 牛顿法计算平方根
     */
    public static double squart(double s) {
        double t = s;
        while (Math.abs(t - s / t) > .001)
            t = (s / t + t) / 2.0;
        return t;
    }

    /**
     * 将整数转换成二进制字符串
     *
     * @param t
     * @return
     */
    public static String toBinaryString(int t) {
        String s = "";
        for (int n = t; n > 0; n /= 2)
            s = (n % 2) + s;
        return s;
    }


    /**
     * 打印数组中的各个元素出现次数
     *
     * @param a
     * @param m
     * @return
     */
    public static int[] histogram(int[] a, int m) {
        int[] f = new int[m];
        for (int e : a) {
            if (e < f.length) {
                f[e] += 1;
            }
        }
        return f;
    }

}
