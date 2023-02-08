package ArrayNesting;
import java.util.*;
public class ArrayNesting {
    int[] dp;
    public int arrayNesting(int[] nums){
        int res = 0;
        dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> set = new HashSet<>();
            res = Math.max(res, dfs(nums, i, set));
        }
        return res;
    }

    public int dfs(int[] nums, int index, HashSet<Integer> set){
        if(dp[index] != 0) return dp[index];
        if(set.contains(nums[index])) return dp[index] = set.size();
        set.add(nums[index]);
        dp[index] = dfs(nums, nums[index], set);
        set.remove(set.size() - 1);
        return dp[index];
    }
    
}
