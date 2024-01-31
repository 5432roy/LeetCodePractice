"""
739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
If there is no future day for which this is possible, keep answer[i] == 0 instead.

https://leetcode.com/problems/daily-temperatures/description/
"""
class Solution:
    """
    Using a stack to keep track of the days that we haven't find a warmer day.
    For each day, we check every day in the stack and see if today's temp is higher than those days.
    If yes we pop that day from the stack and see which day it is, then we know how many days it has been waiting.
    After checking, we push today's value into the stack, since we haven't found a warmer day than today for sure.
    """
    def dailyTemperatures(self, temps: [int]) -> [int]:
        stack = []
        res = [0 for i in range(len(temps))]
        
        for i in range(len(temps)):
            while len(stack) > 0 and temps[i] > stack[-1][0]:
                cooler = stack.pop()
                res[cooler[1]] = i - cooler[1]
            stack.append((temps[i], i))
        
        return res