"""
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

https://leetcode.com/problems/jump-game-ii/description/
"""

class Solution:
    def jump(self, nums: list[int]) -> int:
        res, n = 0, len(nums)
        # curMax is the maximum index we can get to with curretn jumps, nextMax is the maximum index we can get with next jump
        curMax, nextMax = 0,0
        
        for i in range(n - 1):
            nextMax = max(nextMax, i + nums[i])
            # if current jump could not reach not index, we need to jump again
            if i == curMax:
                res += 1
                curMax = nextMax

        return res