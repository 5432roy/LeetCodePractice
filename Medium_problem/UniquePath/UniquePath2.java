package UniquePath;

public class UniquePath2 {

    public static void main(String[] args){
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathWithObstacles(obstacleGrid));
    }

    public static int uniquePathWithObstacles(int[][] obstacleGrid){
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        return paths(obstacleGrid.length - 1, obstacleGrid[0].length - 1, memo, obstacleGrid);
    }

    public static int paths(int m, int n, int[][] memo, int[][] obstacleGrid){
        if(m == -1 || n == -1) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        if(memo[m][n] != 0) return memo[m][n];
        memo[m][n] = paths(m - 1, n, memo, obstacleGrid) + paths(m, n - 1, memo, obstacleGrid);
        return memo[m][n];
    }
    
}
