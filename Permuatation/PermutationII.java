package Permuatation;
import java.util.*;
public class PermutationII {
    boolean[] used;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        res = new ArrayList<>();
        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(list, nums);

        return res;
    }

    public void dfs(List<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() > nums.length) return;
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                list.add(nums[i]);
                used[i] = true;
                dfs(list, nums);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }  
        return;
    }
    
    
}
