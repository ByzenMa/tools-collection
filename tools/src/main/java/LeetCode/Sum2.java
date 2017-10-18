package LeetCode;

import java.util.Arrays;

public class Sum2 {

    public static void print(int[] s, int k) {
        Arrays.sort(s);
        if (s[0] > k) return;
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (s[i] + s[j] == k) System.out.println(s[i++] + " " + s[j--]);
            else if (s[i] + s[j] > k) j--;
            else i++;
        }
    }

    public static void main(String[] args) {
        int[] s = {1, 9, 3, 6, 5, 7, 4, 8, 2, 0};
        print(s, 9);
    }
}
