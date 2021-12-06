package WeeklyContest250;
import java.util.*;
public class Third {
    
    public static void main(String[] args){
        int[][] points = new int[][]{{1,2,3},{1,5,1},{5,1,10}};
        System.out.println(maxPoints(points));
    }
    // dynamic programming
    public static long maxPoints(int[][] points){
        int m = points.length, n = points[0].length;
        long ans = 0;
        long[] dp = new long[n];

        for(int row = 0; row < m; row++){
            //find out the value of each col if we add the value which directly below them
            for(int col = 0; col < n; col++){
                dp[col] += points[row][col];
            }
            System.out.println(Arrays.toString(dp));
            //find out and set the value of this row from left to right
            for(int col = 1; col < n; col++){
                dp[col] = Math.max(dp[col], dp[col-1] - 1);
            }
            System.out.println(Arrays.toString(dp));
            //from right to left
            for(int col=n-2;col>=0;col--){
                dp[col] = Math.max(dp[col], dp[col+1] - 1);
            }
            System.out.println(Arrays.toString(dp));
        }
        for(int row=0;row<n;row++){
            ans = Math.max(ans, dp[row]);
        }
        return ans;
    }
}
