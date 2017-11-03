package LeetCode;

import java.util.*;

public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++)
            for (int root = 1; root <= level; root++)
                dp[level] += dp[level - root] * dp[root - 1];
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }


    public static void f() {
        Set<Integer> s = new HashSet<Integer>();
        s.add(1);
        List<Integer> l = new ArrayList<>();
    }

}
