"""
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

https://leetcode.com/problems/fruit-into-baskets/description/
"""

class Solution:
    def totalFruit(self, fruits: list[int]) -> int:
        res, prev = 0, -1
        memo = {}
        queue = []
        # iterate through the list
        for i in fruits:
            # count the nubmer of each kind of fruit
            memo[i] = memo.get(i, 0) + 1
            # sliding window using queue
            queue.append(i)
            # if there are more than two kinds of fruit in the memo, we need to remove the oldest one
            while len(memo) > 2 :
                # pop the front to remove
                pop = queue.pop(0)
                memo[pop] = memo.get(pop) - 1
                if memo[pop] == 0:
                    memo.pop(pop)
            # keep track the length of the queue to get the res
            res = max(res, len(queue))
        return res