package Round1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        int totalNode = 0, currentNode = 0;
        double sum = 0;
        queue.add(root);
        totalNode = 1;
        currentNode = totalNode;
        List<Double> re = new LinkedList<>();

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();
            currentNode -= 1;
            sum += current.val;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);

            if (currentNode == 0) {
                re.add(sum / totalNode);
                totalNode = queue.size();
                currentNode = totalNode;
                sum = 0;
            }
        }

        return re;
    }


}
