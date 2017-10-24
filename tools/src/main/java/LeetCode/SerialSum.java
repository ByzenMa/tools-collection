package LeetCode;

public class SerialSum {

    public static void print(int n) {
        if (n < 2) return;
        int h = 1, t = 2, sum = h + t;
        while (h < t) {
            if (sum == n) {
                print(h, t);
                sum += ++t;
            } else if (sum < n) sum += ++t;
            else sum -= h++;
        }
    }

    public static void print(int from, int to) {
        for (int i = from; i <= to; i++) {
            if (i == to) System.out.println(i);
            else System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        print(15);
    }
}
