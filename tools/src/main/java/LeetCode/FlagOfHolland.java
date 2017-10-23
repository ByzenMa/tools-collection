package LeetCode;

public class FlagOfHolland {

    public static void sort(char[] x) {
        int N = x.length;
        int r = 0;
        for (int i = 0; i < N; i++) {
            if (x[i] == 'r') {
                char tmp = x[i];
                x[i] = x[r];
                x[r++] = tmp;
            }
        }

        int b = N - 1;
        for (int j = N - 1; j >= 0; j--) {
            if (x[j] == 'b') {
                char tmp = x[j];
                x[j] = x[b];
                x[b--] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] cs = {'r', 'b', 'w', 'r', 'b', 'w', 'r', 'b', 'w', 'r', 'b', 'w', 'r', 'b', 'w'};
        sort(cs);
        for (char c : cs) System.out.print(c + " ");
    }

}
