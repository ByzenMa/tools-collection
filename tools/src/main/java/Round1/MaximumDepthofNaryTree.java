package Round1;

public class MaximumDepthofNaryTree {

    public int maxDepth(Node root){

        if(root==null) return 0;

        int maxSubDepth = 0;
        for(Node node: root.children)
            maxSubDepth = Math.max(maxDepth(node), maxSubDepth);

        return maxSubDepth + 1;
    }

}
