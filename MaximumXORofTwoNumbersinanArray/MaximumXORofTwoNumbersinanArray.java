package MaximumXORofTwoNumbersinanArray;
import java.util.*;
public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, res = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            
            HashSet<Integer> set = new HashSet<Integer>();
            
            for(int num : nums){
                int cur = num & mask;
                set.add(cur);
            }
            
            int greedy = res | (1 << i);
            
            for(int num : set){
                int valid = num ^ greedy;
                if(set.contains(valid)){
                    res = greedy;
                    break;
                }
            }
        }
        
        return res;
    }
    
}
