package DeleteAndEarn;
import java.util.*;
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] dp = new int[map.size()];
        if(map.size() < 2) return nums[0] * nums.length;
        int cur = 0, prev = Integer.MAX_VALUE;
        while(!map.isEmpty()){
            int num = map.lastEntry().getKey(), times = map.lastEntry().getValue();
            if(cur == 0) dp[0] = num * times;
            else if(cur == 1) dp[1] = num == prev - 1 ? Math.max(dp[0], num * times) : dp[0] + num * times;
            else{
                dp[cur] = num == prev - 1 ? Math.max(dp[cur - 1], dp[cur - 2] + num * times) : dp[cur - 1] + num * times;
            }
            prev = num;
            map.remove(prev);
            cur++;
        }

        
        return dp[dp.length - 1];
    }
    
}
