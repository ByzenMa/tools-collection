package LeetCode;

public class PerfectShuffle {

    public static void basic(int[] x) {
        int N = x.length;
        assert N % 2 == 0;
        for (int i = N / 2 - 1; i > 0; i--)
            for (int j = i; j < N - i; j += 2)
                exch(x, i, i + 1);
    }

    public static void exch(int[] x, int i, int j) {
        if (i == j) return;
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
        basic(x);
        for (int e : x) System.out.print(e + " ");
    }
}
