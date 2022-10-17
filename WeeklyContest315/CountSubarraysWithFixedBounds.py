class Solution:
    def countSubarrays(self, nums: list[int], minK: int, maxK: int) -> int:
        res, min_i, max_i, head, n = 0, -1, -1, -1, len(nums)
        for i in range(n):
            if nums[i] == minK: min_i = i
            if nums[i] == maxK: max_i = i
            if nums[i] < minK or nums[i] > maxK: head = i
            print(f"min: {min_i}, max: {max_i}, head: {head}")
            res += max(0, min(max_i, min_i) - head)
        return res


s = Solution()
print(s.countSubarrays(nums = [1,3,5,2,7,5], minK = 1, maxK = 5))
print(s.countSubarrays(nums = [1,1,1,1], minK = 1, maxK = 1))