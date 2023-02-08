package MinimumPathSum;
import java.util.*;
public class MinimumPathSum {

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        int sum = findSum(grid, grid.length - 1, grid[0].length - 1, dp);
        for(int i = 0; i < grid.length; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return sum;
    }
    // if you can't let m or n smaller than 0, just create other base cases to prevent that situation
    public static int findSum(int[][] grid, int m, int n, int[][] dp){
        if(m == 0 && n == 0) return grid[0][0];
        if(dp[m][n] != 0) return dp[m][n];
        if(m == 0 && n != 0) return dp[m][n] = findSum(grid, m, n - 1, dp) + grid[m][n];
        if(m != 0 && n == 0) return dp[m][n] = findSum(grid, m - 1, n, dp) + grid[m][n];

        return dp[m][n] = Math.min(findSum(grid, m - 1, n, dp), findSum(grid, m, n - 1, dp)) + grid[m][n];
    }
    
}
