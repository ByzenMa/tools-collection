package Round1;

import java.util.*;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Integer> ls = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            ls.add(current.val);
            List<Node> children = current.children;
            for (int i=children.size()-1;i>=0;i--) {
                if (children.get(i) != null) stack.add(children.get(i));
            }
        }
        return ls;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}