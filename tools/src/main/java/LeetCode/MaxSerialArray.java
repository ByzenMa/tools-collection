package LeetCode;

public class MaxSerialArray {

    public static int max(int[] x) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] x = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(max(x));
    }
}
