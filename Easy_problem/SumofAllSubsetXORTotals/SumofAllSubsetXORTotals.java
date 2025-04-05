/*
 * 1863. Sum of All Subset XOR Totals
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2025-04-05
 * 
 * Backtrack to go through every subset
 */
class Solution {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += backtrack(nums, i, 0);
        }
        return res;
    }

    private int backtrack(int nums[], int i, int cur) {
        if(i == nums.length) {
            return 0;
        }

        cur ^= nums[i];
        int res = cur;
        for(int j = i + 1; j < nums.length; j++) {
            res += backtrack(nums, j, cur);
        }
        cur ^= nums[i];

        return res;
    }
}