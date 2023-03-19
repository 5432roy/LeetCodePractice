"""
You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.

Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.

Return an integer array answer where answer = [even, odd].

https://leetcode.com/contest/weekly-contest-337/problems/number-of-even-and-odd-bits/
"""

class Solution:
    """ easy problem the code is self-explainary """
    def evenOddBit(self, n: int) -> list[int]:
        res = [0,0]
        b = False
        
        while n > 0:
            if (n & 1) == 1:
                if b:
                    res[1] += 1
                else:
                    res[0] += 1
            b = not b
            n = n >> 1
        return res
