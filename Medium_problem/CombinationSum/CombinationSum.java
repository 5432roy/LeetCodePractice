package CombinationSum;

import java.util.*;

public class CombinationSum {
    //backtrack
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        combinationSumRecursive(nums, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private List<List<Integer>> combinationSumRecursive(int[] candidates, int target, int startFrom) {
        List<List<Integer>> finalResults = new ArrayList<>();

        for (int i = startFrom; i < candidates.length; i++) {
            if (candidates[i] > target) continue; 
            else if (candidates[i] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(candidates[i]);
                finalResults.add(result);
            } else {
                List<List<Integer>> results = combinationSumRecursive(candidates, target - candidates[i], i);
                if (!results.isEmpty()) {
                    for (List<Integer> result : results) {
                        result.add(candidates[i]);
                        finalResults.add(result);
                    }
                }
            }
        }
        return finalResults;
    }

    
}
