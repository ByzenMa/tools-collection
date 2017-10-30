package LeetCode;

public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int r = m, c = n;
        for (int i = 0; i < ops.length; i++) {
            int ru = ops[i][0] > m ? m : ops[i][0];
            int cu = ops[i][1] > n ? n : ops[i][1];
            if (r > ru) r = ru;
            if (c > cu) c = cu;
        }
        return r * c;
    }

}
