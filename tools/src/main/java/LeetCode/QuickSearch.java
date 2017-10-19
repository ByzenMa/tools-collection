package LeetCode;

public class QuickSearch {

    public static int search(int[] s, int lo, int hi, int k) {
        if (hi - lo < k - 1 || k < 1) return -1;
        int p = partition(s, lo, hi);
        int span = p - lo;
        if (span == k - 1) return s[p];
        else if (span > k - 1) return search(s, lo, p - 1, k);
        else return search(s, p + 1, hi, k - span - 1);
    }

    private static int partition(int[] s, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (i < j) {
            while (s[i] < s[lo]) i++;
            while (s[j] > s[lo]) j--;
            if (i < j) {
                int tmp = s[i];
                s[i++] = s[j];
                s[j--] = tmp;
            }
        }
        i--;
        int tmp = s[lo];
        s[lo] = s[i];
        s[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] s = {2, 1, 3, 4, 7, 6, 9, 8, 5};
        System.out.println(search(s, 0, s.length - 1, 7));
    }

}
