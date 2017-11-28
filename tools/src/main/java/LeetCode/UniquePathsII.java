package LeetCode;

public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int n=obstacleGrid.length, m=obstacleGrid[0].length;
        int[][] c = new int[n+1][m+1];
        int[][] cur = new int[n+1][m+1];


        for(int i=1;i<=n;i++)
            for(int j=1; j<=m; j++) cur[i][j] = obstacleGrid[i-1][j-1];


        for(int i=1;i<=n;i++)
            for(int j=1; j<=m; j++) {
                int up = cur[i][j-1]==1?0:c[i][j-1];
                int left = cur[i-1][j]==1?0:c[i-1][j];
                c[i][j] = cur[i][j]==1?0:(up+left);
            }

        return c[n][m];
    }

    public static void main(String[] args) {
        int[][] in = {{0}};
        System.out.println(uniquePathsWithObstacles(in));
    }


}
