package com.nlp.basic.tools.algorithm.chapter2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Frequency {

    private class Record implements Comparable<Record> {
        String item;
        int freq;

        public Record(String item, int freq) {
            this.item = item;
            this.freq = freq;
        }


        @Override
        public int compareTo(Record o) {
            if (this.freq > o.freq) return 1;
            else if (this.freq == o.freq) return 0;
            else return -1;
        }
    }

    public void sort(String[] in) {
        Arrays.sort(in);

        Record[] r = new Record[in.length];
        String word = in[0];
        int count = 0;
        r[count++] = new Record(word, 1);
        for (int i = 1; i < in.length; i++) {
            if (in[i].equals(word)) r[count - 1].freq += 1;
            else {
                word = in[i];
                r[count++] = new Record(word, 1);
            }
        }

        Arrays.sort(r, 0, count, Collections.<Record>reverseOrder());
        for (int i = 0; i < count; i++) {
            System.out.println(r[i].item + " " + r[i].freq);
        }
    }


    public static void main(String[] args) {
        String[] in = {"a", "a", "b", "c", "a", "b", "e", "c"};
        Frequency f = new Frequency();
        f.sort(in);
    }

}
