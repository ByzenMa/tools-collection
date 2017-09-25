package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class FindModeinBinarySearchTree {


    public int[] findMode(TreeNode root) {
        Set<Integer> set = new HashSet<Integer>();
        findMode(root, set);
        int[] result = new int[set.size()];
        int count = 0;
        for (int e : set) {
            result[count++] = e;
        }
        return result;
    }

    void findMode(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        if (!set.contains(root.val) && (contains(root.left, root.val) || contains(root.right, root.val)))
            set.add(root.val);
        findMode(root.left, set);
        findMode(root.right, set);
    }

    boolean contains(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return contains(root.left, val) || contains(root.right, val);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;

        FindModeinBinarySearchTree test = new FindModeinBinarySearchTree();
        int[] re = test.findMode(node1);
        for(int e: re) {
            System.out.print(e + " ");
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}