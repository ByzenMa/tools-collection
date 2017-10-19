package LeetCode;

public class FindAllCombination {

    public static void find(int n, int sum, String s) {
        if (n < 1 || sum < 0) return;
        if (sum == 0) {
            System.out.println(s);
            return;
        }
        if (sum < n) {
            find(n - 1, sum, s);
            return;
        }
        find(n - 1, sum - n, s + " " + n);
        find(n - 1, sum, s);
    }

    public static void main(String[] args) {
        find(10, 15, "");
    }
}
