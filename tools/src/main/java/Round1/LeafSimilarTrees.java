package Round1;

import com.nlp.basic.tools.stdlib.In;

import java.util.*;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> ls1 = getLeaves(root1);
        List<Integer> ls2 = getLeaves(root2);

        if (ls1.size() != ls2.size()) return false;

        for (int i = 0; i < ls1.size(); i++)
            if (ls1.get(i) != ls2.get(i)) return false;

        return true;
    }

    private List<Integer> getLeaves(TreeNode root) {

        if (root == null) return Collections.emptyList();
        List<Integer> ls = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) queue.add(current);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);

        }

        while (!queue.isEmpty()) ls.add(queue.poll().val);
        return ls;
    }


}
