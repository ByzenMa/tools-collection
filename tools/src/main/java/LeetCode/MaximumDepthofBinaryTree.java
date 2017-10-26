package LeetCode;

public class MaximumDepthofBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode x) {
        if (x == null) return 0;
        return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;
    }

}

