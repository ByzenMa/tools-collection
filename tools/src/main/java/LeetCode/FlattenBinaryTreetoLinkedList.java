package LeetCode;

public class FlattenBinaryTreetoLinkedList {

    public static void flatten(TreeNode root) {
        if (root == null) return;
        flattenSubTree(root);
    }

    private static TreeNode flattenSubTree(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        else if (root.left == null) return flattenSubTree(root.right);
        else if (root.right == null) {
            TreeNode ll = flattenSubTree(root.left);
            root.right = root.left;
            root.left = null;
            return ll;
        } else {
            TreeNode ll = flattenSubTree(root.left);
            ll.right = root.right;
            TreeNode lr = flattenSubTree(root.right);
            root.right = root.left;
            root.left = null;
            return lr;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        flatten(n1);
        System.out.println(n1);
    }
}
