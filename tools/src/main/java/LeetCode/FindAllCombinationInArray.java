package LeetCode;

public class FindAllCombinationInArray {

    public static void find(int[] x, int sum, int n, String s) {
        if (n < 0 || sum < 0) return;
        if (sum == 0) {
            System.out.println(s);
            return;
        }
        find(x, sum - x[n], n - 1, s + " " + x[n]);
        find(x, sum, n - 1, s);
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 2, 4, 5, 9, 8, 7};
        find(x, 15, x.length - 1, "");
    }
}
