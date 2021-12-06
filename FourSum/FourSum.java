package FourSum;

import java.util.*;

public class FourSum {

    public static void main(String[] args){
        int[] nums = {1,0,-1,0,-2,2};
        //System.out.println(threeSum(nums, 1, 0).toString());
        System.out.println(fourSum(nums, 0).toString());

    }

    public static List<List<Integer>> fourSum(int[] nums, int target){

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1])
            ans.addAll(threeSum(nums, i + 1, target - nums[i]));
        }

        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums, int head, int target){

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = head; i < nums.length-2; i++) {
            if (i == head || nums[i] != nums[i-1]) {
                int lo = i+1, hi = nums.length-1, sum = target - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        ans.add(Arrays.asList(nums[head - 1], nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    } else {
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    }
                }
            }
        }

        return ans;
    }
    
}
