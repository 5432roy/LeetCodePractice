package PartitionArrayIntoDisjointIntervals;

public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] nums){
        int[] min = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            min[i] = Math.min(nums[i], min[i + 1]);
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            max[i] = Math.max(nums[i], max[i - 1]);
        }

        int ans = 1;

        while(min[ans] < max[ans - 1] && ans < nums.length){
            ans++;
        }

        return ans;
    }
    
}
