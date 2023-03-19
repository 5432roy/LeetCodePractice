"""
You are given an array nums of positive integers and a positive integer k.

A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

Return the number of non-empty beautiful subsets of the array nums.

A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. 
Two subsets are different if and only if the chosen indices to delete are different.

https://leetcode.com/contest/weekly-contest-337/problems/the-number-of-beautiful-subsets/
"""
class Solution:
    """
    for every number n, there are two numbers that cannot exist in the same subset to be beautiful, n - k and n + k
    
    To deal with subset, backtracking is one of the most instinct solution to have
    
    For every number, we have two cases:
    1. the number is valid to make a beautiful after adding it
        In this cases, we have two option:
            (1) add it and we have a new subset
            (2) ignore it because we may have another value that have comflict with it
    2. the number is not valid to add it:
        We have no choice but to skip it
    
    When adding/removing a value, we update the dictionary "invalid"
    the key store the number that would have conflict with the current subset
    the value store how many numbers in the current subset would have conflict with the value of key
    """
    def beautifulSubsets(self, nums: list[int], k: int) -> int:
        res = 0

        res += self.helper(nums, k, 0, {})
        
        return res
    
    def helper(self, nums, k, i, invalid):
        # base case
        if i == len(nums):
            return 0
        
        res = 0
        
        # case we can take this number
        if nums[i] not in invalid.keys() or invalid.get(nums[i]) == 0:
            
            res += 1
            invalid[nums[i] - k] = invalid.get(nums[i] - k, 0) + 1
            invalid[nums[i] + k] = invalid.get(nums[i] + k, 0) + 1
            
            res += self.helper(nums, k, i + 1, invalid)
            
            invalid[nums[i] - k] -= 1
            invalid[nums[i] + k] -= 1
            
        
        # case we skip this number
        res += self.helper(nums, k, i + 1, invalid)
        
        return res
