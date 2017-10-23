package LeetCode;

public class InsertionSortCountExch {

    public static int sort(int[] x) {
        int count = 0;
        for (int i = 1; i < x.length; i++) {
            int tmp = x[i];
            int j = i;
            for (; j > 0 && tmp < x[j - 1]; j--) {
                x[j] = x[j - 1];
                count++;
            }
            x[j] = tmp;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] x = {4, 1, 3, 2};
        System.out.println(sort(x));
    }
}
