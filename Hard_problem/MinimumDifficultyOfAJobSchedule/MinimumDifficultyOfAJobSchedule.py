import functools

class Solution:
    def minDifficulty(self, jobDifficulty: list[int], d: int) -> int:
        if len(jobDifficulty) < d:
            return -1

        n = len(jobDifficulty)

        @functools.lru_cache(None)
        def dp(cur, d):
            if d > n - cur:
                return float('inf')
            if d == 1:
                return max(jobDifficulty[cur:])
            res = float('inf')
            maxDifficulty = 0
            for i in range(cur, n):
                maxDifficulty = max(maxDifficulty, jobDifficulty[i])
                res = min(res, maxDifficulty + dp(i + 1, d - 1))
            return res
        return dp(0, d)


solution = Solution()
print(solution.minDifficulty(jobDifficulty = [6,5,4,3,2,1], d = 2))