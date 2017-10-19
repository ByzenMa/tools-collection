package LeetCode;

import java.util.Arrays;

public class FindSum {

    public static void find(int[] x, int sum) {
        Arrays.sort(x);
        if (sum < x[0]) return;

        int i = 0, j = x.length - 1;
        while (i < j) {
            int s = x[i] + x[j];
            if (s == sum) System.out.println(x[i++] + ", " + x[j--]);
            else if (s > sum) j--;
            else i++;
        }
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        find(x, 9);
    }

}
