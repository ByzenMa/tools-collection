package LeetCode;

public class SingleNumber {

    public static int find(int[] x) {
        for (int i = 1; i < x.length; i++) {
            x[0] = x[0] ^ x[i];
        }
        return x[0];
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 1, 2};
        System.out.println(find(x));
    }
}
