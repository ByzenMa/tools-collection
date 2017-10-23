package LeetCode;

public class LDS {

    public static int lds(int[] x) {
        int N = x.length;
        int[] c = new int[N];
        c[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (x[i] < x[j] && c[i] < c[j] + 1) c[i] = c[j] + 1;
            }
        }

        int mx = 0;
        for (int e : c) if (mx < e) mx = e;
        return mx;
    }

    public static void main(String[] args) {
        int[] x = {9, 4, 3, 2, 5, 4, 3, 2};
        System.out.println(lds(x));
    }
}
