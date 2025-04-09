package Easy_problem.MinimumOperationstoMakeArrayValuesEqualtoK;

import java.util.HashSet;
import java.util.Set;

/*
 * 3375. Minimum Operations to Make Array Values Equal to K
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
 * 
 * Easy question
 */
public class MinimumOperationstoMakeArrayValuesEqualtoK {
        public int minOperations(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int res = 0;

        for(int num : nums) {
            if(num < k) {
                return -1;
            } else if(num > k && !seen.contains(num)) {
                seen.add(num);
                res++;
            }
        }

        return res;
    }
}
