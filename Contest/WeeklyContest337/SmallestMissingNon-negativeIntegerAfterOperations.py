"""
You are given a 0-indexed integer array nums and an integer value.

In one operation, you can add or subtract value from any element of nums.

For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.

For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
Return the maximum MEX of nums after applying the mentioned operation any number of times.

https://leetcode.com/contest/weekly-contest-337/problems/smallest-missing-non-negative-integer-after-operations/
"""
class Solution:
    """
    since we can modify the value in "nums" as we needed,
    for any number A, A is eqivalaence to B after operation for any integer, such that A ≡ B
    
    Hence we just have to keep track of how many number do I have for each modular.
    The smallest number is the number of rounds we can have for the given "value"
    the index is representing which number I cannot have
    """
    def findSmallestInteger(self, nums: list[int], value: int) -> int:
        memo = [0 for i in range(value)]
        
        for num in nums:
            memo[num % value] += 1
        
        mul = float('inf')
        index = 0
        for i in range(value):
            if memo[i] < mul:
                mul = memo[i]
                index = i
        
        return mul * value + index