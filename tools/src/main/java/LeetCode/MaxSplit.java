package LeetCode;

import java.util.Arrays;

import static LeetCode.PerfectShuffle.exch;

public class MaxSplit {

    public static int maxSplit(int[] x) {
        int sum = 0, mx = 0;
        for (int e : x) sum += e;
        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0 && split(x, sum / i, x.length - 1) && i > mx) mx = i;
        }
        return mx;
    }


    public static boolean split(int[] x, int sum, int hi) {
        if (hi < 0) return true;
        Arrays.sort(x, 0, hi);
        int ex = hi, rest = sum;
        for (int i = hi; i >= 0; i--) {
            rest -= x[i];
            if (rest > 0) exch(x, ex--, i);
            else if (rest == 0) {
                exch(x, ex--, i);
                break;
            } else rest += x[i];
        }
        if (rest > 0) return false;
        return split(x, sum, ex);
    }


    public static void main(String[] args) {
        int[] x = {3, 2, 4, 3, 6};
        System.out.println(maxSplit(x));
    }
}
