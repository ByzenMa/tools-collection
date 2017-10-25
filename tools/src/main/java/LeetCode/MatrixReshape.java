package LeetCode;

public class MatrixReshape {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int R = nums.length, C = nums[0].length;
        if (R * C != r * c) return nums;
        int[][] nc = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                nc[i][j] = nums[(i * c + j) / C][(i * c + j) % C];
            }
        }
        return nc;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] nc = matrixReshape(nums, 1, 4);
    }

}
