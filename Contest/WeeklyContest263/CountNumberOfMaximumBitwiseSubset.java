package WeeklyContest263;
import java.util.*;
public class CountNumberOfMaximumBitwiseSubset {
    int res = 0;
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;

        for(int num : nums){
            max |= num;
        }
        List<Integer> used = new ArrayList<>();
        
        backTracking(used, nums, 0, 0, max);
        
        return res;
    }

    private void backTracking(List<Integer> list, int[] nums, int head, int cur, int max){ 
        if(cur == max) {
            //System.out.println(list.toString() + " cur: " + cur + " max: " + max);
            res++;
        }

        for(int i = head; i < nums.length; i++){
            if(list.contains(i)) continue;
            list.add(i);
            backTracking(list, nums, i, cur | nums[i], max);
            list.remove(list.size() - 1);
        }
    }
    
}
