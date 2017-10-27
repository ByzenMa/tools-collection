package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputisaBST {

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> ord = new ArrayList<>();
        inOrder(root, ord);
        int i = 0, j = ord.size() - 1;
        while (i < j) {
            int sum = ord.get(i) + ord.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private static void inOrder(TreeNode root, List<Integer> ord) {
        if (root == null) return;
        inOrder(root.left, ord);
        ord.add(root.val);
        inOrder(root.right, ord);
    }

}
