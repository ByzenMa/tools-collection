package LeetCode;

public class BinarySearchRotateNum {

    public static int search(int[] x, int lo, int hi) {
        if (lo > hi) return -1;
        if (lo == hi) return x[lo];
        int mid = lo + (hi - lo) / 2;
        if (x[mid] < x[mid - 1]) return x[mid];
        else if (x[mid] < x[lo]) return search(x, lo, mid - 1);
        else if (x[mid] > x[hi]) return search(x, mid + 1, hi);
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {3, 4, 5, 6, 7, 8, 9, 1, 2};
        System.out.println(search(x, 0, x.length - 1));
    }

}
