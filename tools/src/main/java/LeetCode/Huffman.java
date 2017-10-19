package LeetCode;

public class Huffman {

    public static void print(HufMNode x, String p) {
        if (x.left == null && x.right == null) {
            System.out.println(x.val + "->" + p);
            return;
        }
        print(x.left, p + '0');
        print(x.right, p + '1');
    }

    public static HufMNode encode(HufMNode[] x, int n) {
        if (n == 1) return x[0];
        init(x, n);
        init(x, n - 1);
        HufMNode newN = new HufMNode();
        newN.weigth = x[n - 1].weigth + x[n - 2].weigth;
        newN.left = x[n - 1];
        newN.right = x[n - 2];
        x[n - 2] = newN;
        return encode(x, n - 1);
    }

    public static void init(HufMNode[] x, int n) {
        int id = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (x[i].weigth < min) {
                min = x[i].weigth;
                id = i;
            }
        }
        exch(x, n - 1, id);
    }

    public static void exch(HufMNode[] x, int n1, int n2) {
        assert n2 < n1;
        HufMNode tmp = x[n1];
        x[n1] = x[n2];
        x[n2] = tmp;
    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 3, 2, 1};
        String[] vals = {"A", "B", "C", "D", "E"};
        HufMNode[] xs = new HufMNode[weights.length];
        for (int i = 0; i < weights.length; i++) {
            xs[i] = new HufMNode();
            xs[i].weigth = weights[i];
            xs[i].val = vals[i];
        }
        HufMNode r = encode(xs, xs.length);
        print(r, "");
    }

}

class HufMNode {
    int weigth;
    String val;
    HufMNode left;
    HufMNode right;
}