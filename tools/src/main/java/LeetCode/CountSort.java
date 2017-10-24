package LeetCode;

public class CountSort {

    public static void sort(int[] x) {
        int R = 100;
        int[] c = new int[R];
        for (int e : x) c[e]++;
        int i = 0;
        for (int j = 0; j < R; j++) {
            while (c[j] > 0) {
                x[i++] = j;
                c[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {2, 1, 3, 4, 5, 1, 23, 10, 2, 3, 22, 10, 98, 45};
        sort(x);
        for (int e : x) System.out.print(e + " ");
    }

}
