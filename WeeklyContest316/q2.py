import functools
class Solution:
    def subarrayGCD(self, nums: list[int], k: int) -> int:
        n, res = len(nums), 0

        @functools.lru_cache(None)
        def get_GCD(num1, num2):
            if num2 > num1:
                temp = num1
                num1 = num2
                num2 = temp

            q = int(num1/num2)
            r = num1 % num2
            if r == 0:
                return num2
            else:
                return get_GCD(num2, r)


        for i in range(n):
            gcd, count = nums[i], 0
            for j in range(i, n):
                gcd = get_GCD(gcd, nums[j])
                if gcd < k:
                    break
                if gcd == k:
                    res += 1
        return res

s = Solution()
print(s.subarrayGCD(nums = [9,3,1,2,6,3], k = 3))
print(s.subarrayGCD(nums = [4,14,7], k = 7))

