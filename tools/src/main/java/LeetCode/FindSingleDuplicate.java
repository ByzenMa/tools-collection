package LeetCode;

public class FindSingleDuplicate {

    public static int find(int[] n) {
        int N = n.length;
        int s = N * (N - 1) / 2;
        int sum = 0;
        for (int e : n) sum += e;
        return sum - s;
    }


    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        System.out.println(find(n));
    }
}
