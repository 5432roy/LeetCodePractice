package MinimumFallingPathSum;

public class MinimumFallingPathSum {

    public static void main(String[] args){
        int[][] nums = new int[][]{{2,3,1},{6,5,4},{7,8,9}};
        minFallingPathSum(nums);
    }
    // similar to WeeklyContest250 third problem
    public static int minFallingPathSum(int[][] nums){
        int dp[] = new int[nums.length];

        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums.length; col++){
                dp[col] += nums[row][col];
            }

            for(int col = 0; col < nums.length - 1; col++){
                dp[col] = Math.min(dp[col], dp[col + 1]);
            }

            for(int col = nums.length - 1; col > 0; col--){
                dp[col] = Math.min(dp[col], dp[col - 1]);
            }

        }
        //System.out.println(Arrays.toString(dp));
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < nums.length; col++){
            ans = Math.min(ans, dp[col]);
        }

        return ans;
    }
    
}
