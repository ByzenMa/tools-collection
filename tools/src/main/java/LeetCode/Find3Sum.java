package LeetCode;

import java.util.Arrays;

public class Find3Sum {

    public static void find(int[] x, int sum) {
        Arrays.sort(x);

        for (int i = 0; i < x.length; i++) {
            int h = 0, t = x.length - 1;
            if (h == i) h++;
            if (t == i) t--;
            while (h < t) {
                int s = x[i] + x[h] + x[t];
                if (s == sum) System.out.println(x[i] + "," + x[h++] + "," + x[t--]);
                else if (s > sum) t--;
                else h++;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        find(x, 10);
    }

}
