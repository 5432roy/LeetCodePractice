package CombinationSumII;
import java.util.*;
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, list, nums, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                if(i == start || nums[i - 1] != nums[i]){
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums, remain - nums[i], i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    
}
