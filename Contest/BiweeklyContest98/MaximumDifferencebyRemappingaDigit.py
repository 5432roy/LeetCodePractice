"""
You are given an integer num. You know that Danny Mittal will sneakily remap one of the 10 possible digits (0 to 9) to another digit.

Return the difference between the maximum and minimum values Danny can make by remapping exactly one digit in num.

Notes:

When Danny remaps a digit d1 to another digit d2, Danny replaces all occurrences of d1 in num with d2.
Danny can remap a digit to itself, in which case num does not change.
Danny can remap different digits for obtaining minimum and maximum values respectively.
The resulting number after remapping can contain leading zeroes.

https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/

"""

class Solution:
    # find the maximum by changing the first non-9 digit into 9 and modify the other same number to 9 respectively
    # find the mimimum by changing the leading digit into 0, and do the same for all the other
    def minMaxDifference(self, num: int) -> int:
        l = []
        
        while num > 0:
            l.insert(0, num % 10)
            num //= 10
        
        change = -1
        for i in range(len(l)):
            if l[i] == 9:
                continue
            change = l[i]
            break
            
        maximum = 0
        for i in range(len(l)):
            maximum *= 10
            if l[i] == change:
                maximum += 9
            else:
                maximum += l[i]
        
        to_min = l[0]
        minimum = 0
        for i in range(len(l)):
            minimum *= 10
            if l[i] == to_min:
                continue
            minimum += l[i]


        return maximum - minimum