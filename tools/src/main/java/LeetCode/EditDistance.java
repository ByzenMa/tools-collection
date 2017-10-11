package LeetCode;

public class EditDistance {

    public static int editDistance(String a, String b) {
        int N = a.length();
        int M = b.length();
        int max = 0;

        int[][] matrix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) matrix[i][0] = i;
        for (int j = 1; j <= M; j++) matrix[0][j] = j;

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) {
                int add = 1;
                if (a.charAt(i - 1) == b.charAt(j - 1)) add--;
                matrix[i][j] = Math.min(matrix[i - 1][j - 1] + add, Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1));
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(editDistance("ADE", "ABCDE"));
    }
}
