package MaximumErasureValue;
import java.util.HashMap;
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0, head = 0, cur = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int newHead = map.get(nums[i]);
                
                while(head <= newHead) {
                    cur -= nums[head];
                    head++;
                }
            }
            cur += nums[i];
            res = Math.max(res, cur);
            map.put(nums[i], i);
        }
        
        return res;        
    }
}
