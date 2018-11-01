package Round1;

public class SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumLeaves(root.left, 'L') + sumLeaves(root.right, 'R');
    }

    private int sumLeaves(TreeNode root, char l) {

        if (root == null) return 0;
        if (root.right == null && root.left == null && l == 'L') return root.val;

        return sumLeaves(root.left, 'L') + sumLeaves(root.right, 'R');
    }
}
