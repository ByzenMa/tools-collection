package Round1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        for (Node node : root.children)
            if (node != null) list.addAll(postorder(node));
        list.add(root.val);
        return list;
    }

    public List<Integer> postorder2(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            for (Node n : node.children)
                if (n != null) stack1.push(n);
        }

        while (!stack2.isEmpty()) list.add(stack2.pop().val);
        return list;
    }

}

