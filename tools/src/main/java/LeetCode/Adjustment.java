package LeetCode;

public class Adjustment {

    public static void adjust(int[] x) {
        int i = 0, j = x.length - 1;
        while (i < j) {
            while (x[i] % 2 == 1) i++;
            while (x[j] % 2 == 0) j--;
            if (i < j) {
                int tmp = x[i];
                x[i++] = x[j];
                x[j--] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        adjust(x);
        for (int e : x) System.out.print(e + " ");
    }

}
