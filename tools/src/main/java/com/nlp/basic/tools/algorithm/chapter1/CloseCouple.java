package com.nlp.basic.tools.algorithm.chapter1;

import java.util.Arrays;

public class CloseCouple {

    public static double[] closed(double[] i) {
        Arrays.sort(i);
        double minSpan = Double.MAX_VALUE;
        int minIdx = 0;
        for (int j = 1; j < i.length; j++) {
            double span = Math.abs(i[j] - i[j - 1]);
            if (span < minSpan) {
                minSpan = span;
                minIdx = j;
            }
        }

        double[] re = new double[2];
        re[0] = i[minIdx];
        re[1] = i[minIdx - 1];
        return re;
    }


    public static void main(String[] args) {
        double[] i = {-0.3, 1.9, -4, 2.0, 5.0, 2.9, -3.4, -2, 2.5, 1.89};
        double[] o = closed(i);
        System.out.println(o[0] + " " + o[1]);
    }

}
