package LeetCode;

import java.util.Stack;

public class IslandPerimeter {


    public static int islandPerimeter(int[][] grid) {
        int N = grid.length, M = grid[0].length, sum = 0;
        Stack<Couple> c = new Stack<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    c.push(new Couple(i, j));
                    break;
                }
            }
            if (!c.isEmpty()) break;
        }


        while (!c.isEmpty()) {
            Couple e = c.pop();
            if (e.r < 0 || e.c < 0 || e.r >= N || e.c >= M) sum++;
            else if (grid[e.r][e.c] == 0) sum++;
            else if (grid[e.r][e.c] == 1) {
                c.push(new Couple(e.r - 1, e.c));
                c.push(new Couple(e.r + 1, e.c));
                c.push(new Couple(e.r, e.c + 1));
                c.push(new Couple(e.r, e.c - 1));
                grid[e.r][e.c]++;
            }
        }
        return sum;
    }

    public int islandPerimeter2(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }

    public static void main(String[] args) {
        int[][] x = {{0}, {1}};
        System.out.println(islandPerimeter(x));
    }


}

class Couple {
    int r;
    int c;

    public Couple(int row, int col) {
        this.r = row;
        this.c = col;
    }
}