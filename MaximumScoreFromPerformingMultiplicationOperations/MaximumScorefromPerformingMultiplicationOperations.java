package MaximumScoreFromPerformingMultiplicationOperations;

public class MaximumScorefromPerformingMultiplicationOperations {
    Integer[][] memo; 
    public int maximumScore(int[] nums, int[] multipliers) {
        memo = new Integer[multipliers.length][multipliers.length];
        return dp(0, 0, nums, multipliers);
    }
    
    private int dp(int left, int right, int[] nums, int[] multipliers) {
        if(left + right == multipliers.length) return 0;
        if(memo[left][right] != null) return memo[left][right];
        int pickLeft = dp(left + 1, right, nums, multipliers) + nums[left] * multipliers[left + right];
        int pickRight = dp(left, right + 1, nums, multipliers) + nums[nums.length - right - 1] * multipliers[left + right];
        return memo[left][right] = Math.max(pickLeft, pickRight);
    }
}

/*
 * start, end, value
 * 2 choices per time
 */
