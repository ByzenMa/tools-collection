package LeetCode;

public class Transpose {

    public static void transpose(int[][] x) {
        assert x.length == x[0].length;
        int N = x.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++) exch(x, i, j);
    }

    private static void exch(int[][] x, int i, int j) {
        if (i == j) return;
        int tmp = x[i][j];
        x[i][j] = x[j][i];
        x[j][i] = tmp;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transpose(x);
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < x.length; j++)
                if (j == x.length - 1) System.out.println(x[i][j]);
                else System.out.print(x[i][j] + " ");
    }
}
