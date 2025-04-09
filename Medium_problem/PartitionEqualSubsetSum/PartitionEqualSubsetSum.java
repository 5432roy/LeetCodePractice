package Medium_problem.PartitionEqualSubsetSum;

/*
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=daily-question&envId=2025-04-09
 * 
 * 1. Find the number we need to build (add up)
 * 2. Use an array, dp, to memorize the number we can have untill we can build to target number
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) {
            return false;
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        int target = sum / 2;

        for(int num : nums) {
            for(int cur = target; cur >= num; cur--) {
                dp[cur] |= dp[cur - num];
            }
        }
        return dp[target];
    }
}
