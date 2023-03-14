"""
You are given a 0-indexed integer array nums.

The low score of nums is the minimum value of |nums[i] - nums[j]| over all 0 <= i < j < nums.length.
The high score of nums is the maximum value of |nums[i] - nums[j]| over all 0 <= i < j < nums.length.
The score of nums is the sum of the high and low scores of nums.
To minimize the score of nums, we can change the value of at most two elements of nums.

Return the minimum possible score after changing the value of at most two elements of nums.

Note that |x| denotes the absolute value of x.

https://leetcode.com/problems/minimum-score-by-changing-two-elements/description/
"""

# Explnation:
# since we can modify two numbers, it is guarantee that low score is always 0, by making these two nubmers have the same value.
# Therefore, the problem is simplify to how to minimize the high score, which is the max diff of the array.
# Furthermoe, if the size of array is less then 3, it is guarantee the result is 0, since we can make the entire array into same value
# if the array is sorted, max diff equals to num[-1] - num[0]
# Due to the fact that we can only change two numbers, there are merely three cases that we need to consider
# 1. the outlier are the first and second element, such as [1,2,8,9,10,12]
# in this case, we modify 1 and 2 to whatever value between 8 and 12. the max diff is then minimize to 12 - 8 = 4, and min diff is 0 as mentioned above
# the max diff is nums[-1] - nums[2]
# 2. the outier are the first and last element, such as [1,5,6,7,8,12]
# in this case, we mdoify 1 and 12 to value between 5 and 8, the max diff is 8 - 5 = 3
# the max diff is nums[-2] - nums[1]
# 3. the outlier are last two elements, such as [1,2,3,4,9,15]
# in this case, max diff is 4 - 1 = 3
# the max diff is nums[-3] - nums[0]

# Time Complexity: O(NlogN), N is the size of the array
class Solution:
    def minimizeSum(self, nums: list[int]) -> int:
        if len(nums) == 3:
            return 0
        
        nums.sort()
        # check all three cases
        res = min(nums[-1] - nums[2], nums[-2] - nums[1], nums[-3] - nums[0])
        
        return res
        