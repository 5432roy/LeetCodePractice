package ThreeSumClosest;

import java.util.*;

public class ThreeSumCloest {

    public static void main(String[] args){
        int[] nums = {-4,-1,1,2};

        System.out.println(threeSUmClosest(nums, 1));

    }

    public static int threeSUmClosest(int[] nums, int target){
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int cur = closest(nums, target - nums[i], i + 1);
            ans = Math.abs(cur) > Math.abs(ans) ? ans : cur;
        }

        return target - ans;
    }

    public static int closest(int[] nums, int target, int head){
        int end = nums.length - 1;
        int difference = Integer.MAX_VALUE;
        while(end > head && difference != 0){
            difference = Math.abs(difference) < Math.abs(target - (nums[head] + nums[end])) ? difference : target - (nums[head] + nums[end]);
            if(nums[head] + nums[end] > target) end--;
            else if(nums[head] + nums[end] < target) head++;
        }

        return difference;
    }


    public int threeSumCloest(int[] nums, int target){
        Arrays.sort(nums);
        int length = nums.length, diff = Integer.MAX_VALUE;

        for(int i = 0; i < length - 2; i++){
            int cur = twoCloset(nums, i + 1, target - nums[i]);
            if(Math.abs(cur) < Math.abs(diff)) diff = cur;
        }

        return target - diff;
    }

    public int twoCloset(int[] nums, int head, int target){
        int difference = Integer.MAX_VALUE, end = nums.length - 1;
        while(end > head){
            int sum = nums[head] + nums[end];
            if(Math.abs(target - sum) < Math.abs(difference))
            difference = target - sum;
            if(difference == 0) return 0;
            if(sum > target) end--;
            else head++;
        }

        return difference;
    }
    
}
