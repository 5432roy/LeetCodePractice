class Solution:
    def makeSimilar(self, nums: list[int], target: list[int]) -> int:
        odds, evens = [], []
        t_odds, t_evens = [], []

        for num in nums:
            if num % 2 == 0:
                evens.append(num)
            else:
                odds.append(num)

        for num in target:
            if num % 2 == 0:
                t_evens.append(num)
            else:
                t_odds.append(num)
        
        odds = sorted(odds)
        evens = sorted(evens)
        t_evens = sorted(t_evens)
        t_odds = sorted(t_odds)

        res = 0
        for i in range(len(odds)):
            res += abs(odds[i] - t_odds[i]) >> 1

        for i in range(len(evens)):
            res += abs(evens[i] - t_evens[i]) >> 1
        
        return res >> 1

s = Solution()
print(s.makeSimilar(nums = [8,12,6], target = [2,14,10]))
print(s.makeSimilar( nums = [1,2,5], target = [4,1,3]))
print(s.makeSimilar(nums = [1,1,1,1,1], target = [1,1,1,1,1]))
                