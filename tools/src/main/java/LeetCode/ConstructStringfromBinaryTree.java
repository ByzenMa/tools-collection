package LeetCode;

public class ConstructStringfromBinaryTree {

    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        String s = "";
        s += t.val;
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) return s;
        s += "(" + left + ")";
        if (!right.equals("")) s += "(" + right + ")";
        return s;
    }

}
