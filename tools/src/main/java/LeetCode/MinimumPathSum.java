package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumPathSum {

    private static class Node {
        int i;
        int j;
        int sum;

        Node(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length, min = Integer.MAX_VALUE;
        if (grid == null || n == 0 || m == 0) return 0;
        Stack<Node> s = new Stack<>();
        s.push(new Node(0, 0, 0));
        while (!s.isEmpty()) {
            Node x = s.pop();
            if (x.i == n - 1 && x.j == m - 1) {
                if (min > x.sum + grid[x.i][x.j]) min = x.sum + grid[x.i][x.j];
                continue;
            }
            if (x.j != m - 1) s.push(new Node(x.i, x.j + 1, x.sum + grid[x.i][x.j]));
            if (x.i != n - 1) s.push(new Node(x.i + 1, x.j, x.sum + grid[x.i][x.j]));
        }
        return min;
    }


    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        System.out.println(minPathSum(grid));

        int count = 0;
        for (int i = 2045; i > 0; i--) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) count++;
        }
    }


}
