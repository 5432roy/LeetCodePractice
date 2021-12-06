package WeeklyContest269;
import java.util.*;
public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target){
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) res.add(i);
        }

        return res;
    }

    
}
