class Solution:
    def findMaxK(self, nums) -> int:
        seen = set()
        res = -1
        for num in nums:
            if abs(num) > res and -num in seen:
                res = abs(num)
            seen.add(num)
        return res