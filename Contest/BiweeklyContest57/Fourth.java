package BiweeklyContest57;
import java.util.*;
public class Fourth {

    public int[] canSeePersonsCount(int[] nums){
            int[] ans = new int[nums.length];
            int length = nums.length;
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[length - 1]);

            for(int i = length - 2; i >= 0; i--){
                int count = 0;
                while(!stack.isEmpty() && nums[i] > stack.peek()){
                    stack.pop();
                    count++;
                }
                ans[i] = count + (stack.isEmpty() ? 0 : 1);
                stack.push(nums[i]);
            }

            return ans;
    }
    
}
