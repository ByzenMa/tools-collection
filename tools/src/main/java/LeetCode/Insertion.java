package LeetCode;

public class Insertion {

    public static void insert(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int j = i + 1, tmp = x[j];
            for (; j > 0 && tmp < x[j - 1]; j--) x[j] = x[j - 1];
            x[j] = tmp;
        }
    }

    public static void mergeSort(int[] x) {
        mergeSort(x, 0, x.length - 1);
    }

    private static void mergeSort(int[] x, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(x, lo, mid);
        mergeSort(x, mid + 1, hi);
        merge(x, lo, mid, hi);
    }

    private static void merge(int[] x, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, n = x.length;
        int[] aux = new int[n];
        for (int k = 0; k < n; k++) aux[k] = x[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid) x[k] = aux[j++];
            else if (j > hi) x[k] = aux[i++];
            else if (aux[i] > aux[j]) x[k] = aux[j++];
            else x[k] = aux[i++];
        }
    }

    public static void quick(int[] x) {
        quickSort(x, 0, x.length - 1);
    }

    private static void quickSort(int[] x, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(x, lo, hi);
        quickSort(x, lo, p - 1);
        quickSort(x, p + 1, hi);
    }

    private static int partition(int[] x, int lo, int hi) {
        int v = x[lo];
        int i = lo + 1, j = hi;
        while (i < j) {
            while (x[i] < v && i < hi) i++;
            while (x[j] > v && j > lo) j--;
            if (i < j) {
                int tmp = x[i];
                x[i++] = x[j];
                x[j--] = tmp;
            }
        }
        if (x[i] >= v) i--;
        x[lo] = x[i];
        x[i] = v;
        return i;
    }

    public static void heapSort(int[] x) {
        int n = x.length;
        int[] aux = new int[n + 1];
        for (int i = 0; i < n; i++) aux[i + 1] = x[i];
        int k = n / 2;
        while (k > 0) sink(aux, k--, n);
        for (int i = n; i > 1; i--) {
            int tmp = aux[i];
            aux[i] = aux[1];
            aux[1] = tmp;
            sink(aux, 1, i - 1);
        }
        for (int i = 1; i <= n; i++) x[i - 1] = aux[i];
    }

    private static void sink(int[] x, int k, int hi) {
        int j = k;
        while (2 * j <= hi) {
            int i = 2 * j;
            if (i < hi && x[i + 1] > x[i]) i++;
            if (x[i] > x[j]) {
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                j = i;
            } else break;
        }
    }


    public static void main(String[] args) {
        int[] x = {1, 2, 7, 3, 9, 2, 0, 6, 8};
        heapSort(x);
        for (int e : x) System.out.print(e + " ");
    }

}
