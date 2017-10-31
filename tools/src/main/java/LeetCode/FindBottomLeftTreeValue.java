package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int lm = 0, n = 1;
        while (q.size() > 0) {
            TreeNode x = q.poll();
            if (n-- == 1) lm = x.val;
            if (x.right != null) q.add(x.right);
            if (x.left != null) q.add(x.left);
            if (n == 0) n = q.size();
        }
        return lm;
    }
}
