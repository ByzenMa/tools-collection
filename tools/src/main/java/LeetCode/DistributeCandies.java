package LeetCode;

import java.util.HashSet;

public class DistributeCandies {

    public static int distribute(int[] x) {
        int N = x.length;
        assert N % 2 == 0;
        HashSet<Integer> i = new HashSet<>();
        for (int e : x) {
            if (i.size() == N / 2) return N / 2;
            i.add(e);
        }
        return i.size();
    }
}
