package WeeklyContest296;
import java.util.*;
public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - min > k) {
                res++;
                min = nums[i];
            }
        }
        return res;
    }
}
