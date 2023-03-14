"""
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    a simple solution using dfs to traverse in a tree.
    Base Case: a node has no child >> return the value carried in "cur"
    Recursion: the node has children so append the current node.val into the "cur" and keep searching in both children
    """
    
    def helper(self, node, cur):
        cur = cur * 10 + node.val
        if node.left is None and node.right is None:
            return cur
        res = 0
        if node.left is not None:
            res += self.helper(node.left, cur)
        if node.right is not None:
            res += self.helper(node.right, cur)
        
        return res

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)