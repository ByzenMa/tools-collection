package com.nlp.basic.tools.algorithm.chapter2;

import java.util.Arrays;

public class DeleteDuplicate {


    public static String[] sort(String[] ins) {
        Arrays.sort(ins);

        int count = 0;
        String[] temp = new String[ins.length];

        temp[count++] = ins[0];
        for (int i = 1; i < ins.length; i++) {
            if (ins[i].equals(temp[count - 1])) continue;
            temp[count++] = ins[i];
        }

        ins = new String[count];
        for (int i = 0; i < count; i++) {
            ins[i] = temp[i];
        }
        return ins;
    }


    public static void main(String[] args) {

        String[] ins = {"a", "b", "a", "d", "e", "e", "c"};
        String[] outs = sort(ins);
        for (String s : outs) {
            System.out.print(s + " ");
        }

    }

}
