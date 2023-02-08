package NextGreaterElementII;
import java.util.*;
public class NextGreaterElementII {
    // O(N^2)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            int next = i == nums.length - 1 ? 0 : i + 1;
            while(nums[next] <= nums[i] && next != i) next = next == nums.length - 1 ? 0 : next + 1;
            res[i] = next == i ? -1 : nums[next];
        }
        
        return res;
    }
    
    // O(N)
    public int[] nextGreaterElementsII(int[] nums){
        int l = nums.length;
        int[] res = new int[l];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < 2 * l; i++){
            int cur = nums[i % l];
            while(!stack.isEmpty() && nums[stack.peek()] < cur){
                res[stack.pop()] = cur;
            }
            if(i < l) stack.push(i);
        }

        return res;
    }
}
