package Easy_problem.MinimumNumberofOperationstoMakeElementsinArrayDistinct;

import java.util.HashSet;
import java.util.Set;

/*
 * 3396. Minimum Number of Operations to Make Elements in Array Distinct
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-09
 */
public class MinimumNumberofOperationstoMakeElementsinArrayDistinct {
    public int minimumOperations(int[] nums) {
        int[] count = new int[101];
        Set<Integer> set = new HashSet<>();
        int len = nums.length, i = 0, res = 0;

        for(int num : nums) {
            set.add(num);
            count[num]++;
        }

        while(len != set.size()) {
            res++;
            for(int j = 0; j < 3 && i < nums.length; j++) {
                count[nums[i]]--;
                len--;
                if(count[nums[i]] == 0) {
                    set.remove(nums[i]);
                }
                i++;
            }
        }
        return res;
    }
}
