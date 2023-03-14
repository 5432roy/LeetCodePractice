"""
You are given a 0-indexed integer array nums.

We say that an integer x is expressible from nums if there exist some integers 0 <= index1 < index2 < ... < indexk < nums.length for which nums[index1] | nums[index2] | ... | nums[indexk] = x. In other words, an integer is expressible if it can be written as the bitwise OR of some subsequence of nums.

Return the minimum positive non-zero integer that is not expressible from nums.

https://leetcode.com/problems/minimum-impossible-or/description/
"""
class Solution:
    def minImpossibleOR(self, nums: list[int]) -> int:
        seen = set(nums)
        
        res = 1
        
        while res in seen:
            res = res << 1
        
        return res
            
        
        