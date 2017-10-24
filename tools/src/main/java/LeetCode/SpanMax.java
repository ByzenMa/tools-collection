package LeetCode;

public class SpanMax {

    public static int max(int[] x) {
        int mx = 0;
        for (int i = 1; i < x.length; i++) {
            int span = Math.abs(x[i] - x[i - 1]);
            if (span > mx) mx = span;
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 12, 34, 4, 12, -10, 31, 23, -13, 34};
        System.out.println(max(x));
    }
}
