package MaximumSubArray;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int curSum = 0;
        for(int num : nums){
            curSum += num;
            ans = Math.max(ans , curSum);
            curSum = Math.max(0, curSum);
        }
        return ans;
    }
    
}
