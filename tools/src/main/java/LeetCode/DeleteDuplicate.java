package LeetCode;


public class DeleteDuplicate {

    public static int[] delete(int[] x) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int e : x) {
            if (e < min) min = e;
            if (max < e) max = e;
        }

        int span = max - min + 1, num = 0;
        int[] c = new int[span];
        for (int e : x) {
            if (c[e - min] == 0) num++;
            c[e - min]++;
        }
        int[] r = new int[num];
        for (int i = 0, j = 0; i < c.length; i++) {
            if (c[i] > 0) r[j++] = i + min;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 0, 2, -1, 999, 3, 999, 88};
        int[] r = delete(x);
        for (int e : r) System.out.print(e + " ");
    }
}
