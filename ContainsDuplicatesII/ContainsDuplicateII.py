class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        seen = {}
        for i in range(len(nums)):
            if nums[i] in seen and i - seen.get(nums[i]) <= k:
                return True
            seen[nums[i]] = i
        return False