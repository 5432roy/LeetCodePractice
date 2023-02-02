"""
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

https://leetcode.com/problems/greatest-common-divisor-of-strings/
"""

def gcdOfStrings(self, str1: str, str2: str) -> str:
    if len(str2) > len(str1):
        str1, str2 = str2, str1
    l1, l2 = len(str1), len(str2)

    res = ""

    for i in range(l2, 0, -1):
        if l2 % i == 0 and str2 == str2[:i] * (l2 // i):
            if l1 % i == 0 and str1 == str2[:i] * (l1 // i):
                return str2[:i]

    return res