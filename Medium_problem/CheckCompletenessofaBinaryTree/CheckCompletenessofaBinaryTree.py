"""
Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    """
    Using a list memo to store the depth of each node
    A complete tree should have a decreasing order of leaf deapth,
    and the difference between head and tail should be less than or equals to 1
    
    helper function traverse the tree to get the depth of the tree 
    """
    def isCompleteTree(self, root:TreeNode) -> bool:
        memo = []
        self.helper(root, 0, memo)
        check = False
        depth = memo[0]

        for i in range(len(memo) - 1):
            if memo[i] == depth - 1:
                if check:
                    return False
                check = True
                depth -= 1
            if memo[i] - depth != 0:
                return False

        return memo[-1] == depth if check else depth - memo[-1] == 1 or depth == memo[-1] 
    
    def helper(self, node, depth, memo):
        if node is None:
            memo.append(depth)
            return
        self.helper(node.left, depth + 1, memo)
        self.helper(node.right, depth + 1, memo)