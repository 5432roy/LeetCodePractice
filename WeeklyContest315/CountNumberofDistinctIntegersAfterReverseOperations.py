class Solution:
    def countDistinctIntegers(self, nums: list[int]) -> int:
        memo = set()
        
        for num in nums:            
            memo.add(num)
            cur = num
            new = 0
            while cur > 0:
                new = new * 10 + int(cur % 10)
                cur = int(cur / 10) 
            memo.add(new)
        return len(memo)