package LeetCode;

public class LIS {

    public static int lis(int[] x) {
        int[] c = new int[x.length];
        c[0] = 1;
        int N = x.length;
        for (int i = 1; i < N; i++)
            for (int j = i - 1; j >= 0; j--) {
                if (x[i] > x[j] && c[i] < c[j] + 1) c[i] = c[j] + 1;
            }

        int mx = 0;
        for (int i = 0; i < N; i++)
            if (mx < c[i]) mx = c[i];
        return mx;
    }

    public static int sli2(int[] x) {
        int N = x.length;
        int[] c = new int[N + 1];
        c[1] = x[0];
        int mxl = 1;
        for (int i = 1; i < N; i++) {
            if (x[i] > c[mxl]) c[++mxl] = x[i];
            else {
                int j = mxl - 1;
                for (; j > 0 && x[i] < c[j]; j--) ;
                c[++j] = x[i];
            }
        }
        return mxl;
    }


    public static void main(String[] args) {
        int[] x = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(sli2(x));
    }

}
