package MinimumOperationsToReduceXToZero;

public class MinimumOperationToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        
        int target = -x;
        for(int i : nums) {
            target += i;
        }
        if(target <= 0) return target == 0 ? nums.length : -1;
        
        int res = Integer.MAX_VALUE, head = 0, cur = 0;
    
        for(int tail = 0; tail < nums.length; tail++) {
            if(cur < target) {
                cur += nums[tail];
            }
            while(cur >= target) {
                if(cur == target) {
                    res = Math.min(res, nums.length - (tail - head + 1));
                }
                cur -= nums[head++];
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
