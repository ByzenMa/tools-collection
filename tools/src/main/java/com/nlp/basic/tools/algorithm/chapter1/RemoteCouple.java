package com.nlp.basic.tools.algorithm.chapter1;

public class RemoteCouple {

    static double[] remote(double[] input) {

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double e : input) {
            if (e < min) {
                min = e;
            }
            if (e > max) {
                max = e;
            }
        }

        double[] re = new double[2];
        re[0] = min;
        re[1] = max;
        return re;
    }


    public static void main(String[] args) {
        double[] i = {-0.3, 1.9, -4, 2.0, 5.0, 2.9, -3.4, -2, 2.5, 1.89};
        double[] o = remote(i);
        System.out.println(o[0] + " " + o[1]);
    }
}
