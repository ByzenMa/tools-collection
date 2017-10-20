package LeetCode;

public class MaxSubMatrix {

    public static int max(int[][] x) {
        int max = Integer.MIN_VALUE;
        int M = x.length, N = x[0].length;
        for (int i = 0; i < M - 1; i++)
            for (int j = 0; j < N - 1; j++) {
                int s = x[i][j] + x[i + 1][j] + x[i + 1][j + 1] + x[i][j + 1];
                if (s > max) max = s;
            }
        return max;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 0, 3, 4}, {2, 3, 4, 5, 1}, {1, 1, 5, 3, 0}};
        System.out.println(max(x));
    }
}
