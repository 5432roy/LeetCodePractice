class Solution:
    def sumOfNumberAndReverse(self, k: int) -> bool:
        return any(a + int(str(a)[::-1]) == k for a in range(k + 1))
        