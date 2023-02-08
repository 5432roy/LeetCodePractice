package Subsets;

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public static void main(String[] args){
        int[] nums = {4,5,0,-2,-3,1};
        System.out.print(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        ans.add(empty);
        for(int i = 0; i < nums.length; i++){  
            List<List<Integer>> next = new ArrayList<List<Integer>>();
            for(List<Integer> cur : ans){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(cur);
                temp.add(nums[i]);
                next.add(temp);
            }
            ans.addAll(next);
        }
        return ans;
    }
    
}
