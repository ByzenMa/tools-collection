package LeetCode;

public class PrintRoute {

    public static void print(BinaryTreeNode x, int k) {
        print(x, k, "");
    }

    private static void print(BinaryTreeNode x, int k, String p) {
        if (x.right == null && x.left == null) {
            if (k == x.val) System.out.println(p + " " + x.val);
            return;
        }

        p += " " + x.val;
        print(x.left, k - x.val, p);
        print(x.right, k - x.val, p);
    }


    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(10);
        BinaryTreeNode n2 = new BinaryTreeNode(5);
        BinaryTreeNode n3 = new BinaryTreeNode(4);
        BinaryTreeNode n4 = new BinaryTreeNode(12);
        BinaryTreeNode n5 = new BinaryTreeNode(7);
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n2.right = n5;

        print(n1, 22);
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}
