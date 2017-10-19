package LeetCode;

import java.util.Arrays;

public class GoogleTest {

    public static void test(int[] a, int[] b, int k) {
        assert a.length == b.length;
        int n = a.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = a[i] + b[j];

        int total = 0, start = 1;
        while (total + start < k) total += start++;
        int left = k - total;
        int[] corner = new int[start];
        for (int i = start - 1, j = 0; i >= 0; i--, j++) corner[i] = matrix[i][j];
        Arrays.sort(corner);
        for (int i = 0; i < start - 1; i++)
            for (int j = 0; j < start - 1 - i; j++)
                System.out.print(matrix[i][j] + " ");

        for (int i = 0; i < left; i++)
            System.out.print(corner[i] + " ");
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 4, 6, 8, 10};
        test(a, b, 4);
    }
}
