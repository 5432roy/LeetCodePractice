/*
 * 629. K Inverse Pairs Array
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs. 
 * Since the answer can be huge, return it modulo 109 + 7.
 * 
 * https://leetcode.com/problems/k-inverse-pairs-array/description/
 */
class Solution {
    /*
     * memo[i][j] = k, means that for arrays from 1 to i, there are k different arrays have exact j inverse pairs.
     * for an array from 1 to i, if we add "i + 1" to the front of the array, we would have i more inverse pairs from the origin array.
     * if we put "i + 1" to the end of the array, the number of inverse pair would be the same.
     * Therefore, we know that memo[i + 1][j] = sum(memo[i][j] ~ memo[i][j-i]).
     * With this we can find out all value with O(n^2*k)
     * We can also notice that memo[i + 1][j + 1] = memo[i + 1][j] - memo[i][j - i] + memo[i][j + 1] to reduce time complexity of calculating each memo[i][j].
     * The time complexity is reduced to O(nk)
     */
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] memo = new int[n + 1][k + 1];
        for(int i = 1; i < n + 1; i++) {
            memo[i][0] = 1;
        }

        for(int j = 1; j < k + 1; j++) {
            for(int i = 2; i < n + 1; i++) {
                memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
                if(j - i >= 0) {
                    memo[i][j] -= memo[i - 1][j - i];
                    if(memo[i][j] < 0) {
                        memo[i][j] += MOD;
                    }
                }
                memo[i][j] %= MOD;
            }
        }

        return memo[n][k];
    }
}