package WeeklyContest256;
import java.util.*;
public class First {


    public int minimumDifference(int[] nums, int k){
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i + k - 1 < nums.length; i++){
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }

        return res;
    }
}
