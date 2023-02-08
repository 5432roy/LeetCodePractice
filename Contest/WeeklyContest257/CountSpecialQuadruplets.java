package WeeklyContest257;
import java.util.*;
public class CountSpecialQuadruplets {

    public int countQuadruplets(int[] nums) {
        int result = 0;
        int n = nums.length;
        HashMap<Integer, Integer> diffCount = new HashMap<>();
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int num = nums[j] - nums[i];
                diffCount.put(num, diffCount.getOrDefault(num, 0) + 1);
            }
            
            for (int j = i - 2; j >= 0; j--) {
                int num = nums[j] + nums[i - 1];
                result += diffCount.getOrDefault(num, 0);
            }
        }
        return result;
    }
}
