package LeetCode;

public class DivisionWithoutDivision {

    public static int[] divide(int[] x) {
        int left = 1, right = 1;
        int[] b = new int[x.length];
        for (int i = 0; i < b.length; i++) b[i] = 1;
        for (int i = 0; i < b.length; i++) {
            b[i] *= left;
            b[b.length - 1 - i] *= right;
            left *= x[i];
            right *= x[b.length - 1 - i];
        }
        return b;
    }


    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b = divide(x);
        for (int e : b) System.out.print(e + " ");
    }

}
