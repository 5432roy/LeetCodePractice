/*
 * 2966. Divide Array Into Arrays With Max Difference
 * You are given an integer array nums of size n and a positive integer k.
 * 
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * 
 * Each element of nums should be in exactly one array.
 * 
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 */

 class Solution {
    /*
     * memo[i] = maximum partition for subarray to ith index
     * memo[i] = Max value of memo[i - 1] + arr[i] ~ memo[i-j] + max(arr[i] ~ arr[i - j + 1]) * (j + 1) 
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];

        memo[0] = arr[0];

        int max = 0;
        for(int i = 0; i < k && i < n; i++) {
            max = Math.max(max, arr[i]);
            memo[i] = max * (i + 1);
        }

        for(int i = k; i < n; i++) {
            max = 0;
            for(int j = 0; j < k; j ++) {
                max = Math.max(max, arr[i - j]);
                memo[i] = Math.max(memo[i], memo[i - j - 1] + max * (j + 1));
            }
        }

        return memo[n - 1];
    }
}