package LargestDivisibleSubset;
import java.util.*;

/*
 * 368. Largest Divisible Subset
 * https://leetcode.com/problems/largest-divisible-subset/description/?envType=daily-question&envId=2025-04-06
 * 
 * dp
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums){
        int n = nums.length, max = 0, index = -1;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            prev[i] = -1;

            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while(index != -1){
            res.add(nums[index]);
            index = prev[index];
        }
        
        return res;
    } 
    
}
