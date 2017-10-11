package LeetCode;

public class CountingSort {
    private static int n = 100;

    public static void sort(int[] a) { // 假设a中数～[1, n];
        int[] count = new int[n + 1]; // 其中0不能用
        int len = a.length;
        //统计各个数字出现的个数
        for (int e : a) count[e + 1]++;
        for (int i = 1; i < n + 1; i++) count[i] += count[i - 1];
        int[] aux = new int[n];
        for (int j = 0; j < len; j++) aux[count[a[j]]++] = a[j];
        for (int k = 0; k < len; k++) a[k] = aux[k];
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 12, 23, 12, 10, 19, 78};
        sort(a);
        for (int e : a) {
            System.out.print(e + " ");
        }

    }
}
