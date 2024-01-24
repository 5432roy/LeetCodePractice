"""
1457. Pseudo-Palindromic Paths in a Binary Tree

Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    """
    Since the question is only asking if the combination of a path can form a palindrome, we only need to check how many elements are having odd numbers of occurence.
    If there are more than 1 elements occurs in odd number o times, there no permuatation of it can form a palindrome.
    Setup two set that keep track of the odd/even occurence numbers.
    Use the tree traversal throught the tree and using the back-tracking to check if the path is valid. 
    """
    
    def traversal(self, node, odds, evens):
        if node is None:
            return 0
        
        res = 0

        if node.val in odds :
            odds.remove(node.val)
            evens.add(node.val)
        else :
            if node.val in evens:
                evens.remove(node.val)
            odds.add(node.val)

        # reach the leaf node
        if node.left is None and node.right is None:
            if len(odds) <= 1:
                res += 1

        res += self.traversal(node.left, odds, evens)

        res += self.traversal(node.right, odds, evens)

        if node.val in odds :
            odds.remove(node.val)
            evens.add(node.val)
        else :
            evens.remove(node.val)
            odds.add(node.val)
        

        return res 

    def pseudoPalindromicPaths (self, root) -> int:
        odds = set()
        evens = set()

        return self.traversal(root, odds, evens)