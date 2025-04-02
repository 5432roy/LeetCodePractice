package Easy_problem.MaximumValueofanOrderedTriplet;

/*
 * 2873. Maximum Value of an Ordered Triplet I
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/?envType=daily-question&envId=2025-04-02
 */
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] max = new int[n];

        max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i]);
        }
        
        int cur = 0;
        for(int i = 0; i < n - 1; i++) {
            res = Math.max(res, (long)(cur - nums[i]) * (long)max[i + 1]);
            cur = Math.max(cur, nums[i]);
        }


        return res;
    }
}