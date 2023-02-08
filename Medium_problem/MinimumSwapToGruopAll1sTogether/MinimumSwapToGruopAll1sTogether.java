package MinimumSwapToGruopAll1sTogether;

public class MinimumSwapToGruopAll1sTogether {
    public int minSwaps(int[] nums) {
        int sum = 0, max = 0, cur = 0;
        
        for(int i : nums) sum += i;
        
        for(int i = 0; i < sum; i++){
            cur += nums[i] == 1 ? 1 : 0;
        }
        max = cur;
        
        for(int i = 0; i < nums.length << 1; i++){
            cur = cur + nums[(i + sum) % nums.length] - nums[i % nums.length];
            max = Math.max(max, cur);
        }
        
        return sum - max;
    }  
    
}
