"""
2966. Divide Array Into Arrays With Max Difference

You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them

https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
"""

class Solution:
    """
    Since the array has exact size of n, this makes it very simple. We just have to sort the array and check if we can form the sub-array for every n elements.
    """
    def divideArray(self, nums: [int], k: int) -> [[int]]:
        nums.sort()

        res = []

        for i in range(2,len(nums),3):
            if nums[i] - nums[i - 2] <= k:
                res.append(nums[i - 2 : i + 1])
            else :
                return []
        return res