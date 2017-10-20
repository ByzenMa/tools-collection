package LeetCode;

public class FindAllKCombination {

    public static void find(int[] x, int sum, int k, int tk, int id, String s) {

        if (id >= x.length || sum < 0 || k > tk) return;
        if (sum == 0 && k == tk) {
            System.out.println(s);
            return;
        }
        find(x, sum - x[id], k + 1, tk, id + 1, s + " " + x[id]);
        find(x, sum, k, tk, id + 1, s);
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 2, 4, 5, 9, 8, 7};
        find(x, 10, 0, 4, 0, "");
    }
}
