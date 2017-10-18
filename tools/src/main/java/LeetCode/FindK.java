package LeetCode;

public class FindK {

    public static int find(int[] s, int k) {
        return find(s, 0, s.length - 1, k);
    }


    public static int find(int[] s, int lo, int hi, int k) {
        if (hi - lo < k - 1) return -1;
        int p = partition(s, lo, hi);
        int span = p - lo;
        if (span == k - 1) return s[p];
        else if (span > k - 1) return find(s, lo, p - 1, k);
        else return find(s, p + 1, hi, k - 1 - span);
    }

    private static int partition(int[] s, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (i < j) {
            while (s[lo] > s[i]) i++;
            while (s[j] > s[lo]) j--;
            int temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
        int temp = s[lo];
        s[lo] = s[--i];
        s[i] = temp;
        return i;
    }


    public static void main(String[] args) {
        int[] s = {2, 1, 3, 4, 7, 6, 9, 8, 5};
        System.out.println(find(s, 4));
    }

}
