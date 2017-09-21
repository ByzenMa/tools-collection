package com.nlp.basic.tools.algorithm.chapter2;

import java.util.Arrays;

public class FindStrCouple {


    public static void findAllCouple(String[] in) {
        Arrays.sort(in);
        for (int i = 1; i < in.length; i++) {
            int j = 1;
            while (i - j >= 0) {
                if (in[i].startsWith(in[i - j])) {
                    String suffix = in[i].substring(in[i - j].length());
                    for (String e : in) {
                        if (e.equals(suffix)) {
                            System.out.println(in[i] + " " + in[i - j] + " " + e);
                        }
                    }
                }
                j++;
            }
        }
    }


    public static void main(String[] args) {
        String[] in = {"thought", "ithought", "am", "i", "iam"};
        findAllCouple(in);
    }


}
