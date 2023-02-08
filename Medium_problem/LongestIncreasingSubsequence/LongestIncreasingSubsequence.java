package LongestIncreasingSubsequence;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums){
        int max = 0;
        int dp[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }

        return max + 1; 
    }
    
}
