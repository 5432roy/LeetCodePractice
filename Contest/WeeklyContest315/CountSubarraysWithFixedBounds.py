class Solution:
    def countSubarrays(self, nums: list[int], minK: int, maxK: int) -> int:
        res, min_i, max_i, head, n = 0, -1, -1, -1, len(nums)
        for i in range(n):
            if nums[i] == minK: min_i = i
            if nums[i] == maxK: max_i = i
            if nums[i] < minK or nums[i] > maxK: head = i
            res += max(0, min(max_i, min_i) - head)
        return res


class Solution2:
    def countSubarrays(self, nums: list[int], minK: int, maxK: int) -> int:
        def cnt(minK: int, maxK: int) -> int:
            ans, curr = 0, 0
            for num in nums:
                if minK <= num <= maxK:
                    curr += 1
                    ans += curr
                else:
                    curr = 0
            print(f"minK: {minK}, maxK: {maxK}, ans: {ans}")
            return ans
        
        return cnt(minK, maxK) - cnt(minK, maxK - 1) - cnt(minK + 1, maxK) + cnt(minK + 1, maxK - 1)

s = Solution2()
print(s.countSubarrays(nums = [1,3,5,2,7,5], minK = 1, maxK = 5))
print(s.countSubarrays(nums = [1,1,1,1], minK = 1, maxK = 1))