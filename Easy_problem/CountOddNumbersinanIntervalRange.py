"""
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/
"""

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        return (high - low + 1) // 2 + (1 if low % 2 == 1 and high % 2 == 1 else 0)