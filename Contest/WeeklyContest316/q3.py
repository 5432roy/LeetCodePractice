from cmath import cos
from re import M
from turtle import right


class Solution:
    def minCost(self, nums: list[int], cost: list[int]) -> int:
        n = len(nums)
        left, right, res = min(nums), max(nums), 0

        def helper(mid):
            res = 0
            for i in range(n):
                res += abs(nums[i] - mid) * cost[i]
            return res

        while left < right:
            mid = (left + right) >> 1
            l, r = helper(mid), helper(mid + 1)
            res = min(l, r)
            if l > r:
                left = mid + 1
            else:
                right = mid
        return res



s = Solution()
# 1907611126748
print(s.minCost(nums = [735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518], cost = [724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614]))
