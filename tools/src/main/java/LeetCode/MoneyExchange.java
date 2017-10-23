package LeetCode;

public class MoneyExchange {

    public static int exch(int n) {
        int[] b = new int[10];
        b[0] = 1;
        int[] m = {1, 2, 5, 10};
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = 0; j < m.length; j++) {
                if (i >= m[j]) s += b[(i - m[j]) % 10];
            }
            b[i % 10] = s;
        }
        return b[n % 10];
    }

    public static void main(String[] args) {
        System.out.println(exch(10));
    }

}
