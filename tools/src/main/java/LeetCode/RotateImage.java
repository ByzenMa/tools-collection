package LeetCode;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }

        for (int i = 0; i < n; i++) {
            int h = 0, t = n - 1;
            while (h < t) {
                int tmp = matrix[i][h];
                matrix[i][h++] = matrix[i][t];
                matrix[i][t--] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] in = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(in);
    }
}
