package SubSetsII;
import java.util.*;
public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(res, list, nums, 0);

        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));
        
        if(index >= nums.length) return;
        
        for(int i = index; i < nums.length; i++){
            if(i == index || nums[i] != nums[i - 1]){
            list.add(nums[i]);
            backTracking(res, list, nums, i + 1);
            list.remove(list.size() - 1);
            }
        }
    }
    
}
