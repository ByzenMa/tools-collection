package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> a = new ArrayList<Integer>();
        if (root == null) return a;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int mx = Integer.MIN_VALUE, n = 1;
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            if (x.val > mx) mx = x.val;
            if (x.left != null) q.add(x.left);
            if (x.right != null) q.add(x.right);
            if (n-- == 1) {
                a.add(mx);
                mx = Integer.MIN_VALUE;
                n = q.size();
            }
        }
        return a;
    }
}
