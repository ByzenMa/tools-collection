package LeetCode;

public class LCS {

    public static String lcs(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();

        int[][] matrix = new int[N + 1][M + 1];

        int max = 0, maxX = 0;
        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j < M + 1; j++) {
                int add;
                if (i == 1 || j == 1)
                    add = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 1 : 0;
                else add = (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 2) == s2.charAt(j - 2)) ? 1 : 0;
                matrix[i][j] = Math.max(matrix[i - 1][j - 1] + add, Math.max(matrix[i][j - 1], matrix[i - 1][j]));
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxX = i;
                }
            }

        return s1.substring(maxX - max, maxX);
    }

    public static void main(String[] args) {
        String s1 = "wepiabc";
        String s2 = "pabcni";
        System.out.println(lcs(s1, s2));
    }
}
