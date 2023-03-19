"""
There is a knight on an n x n chessboard. In a valid configuration, 
the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1] 
where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. 
The moves are 0-indexed.

Return true if grid represents a valid configuration of the knight's movements or false otherwise.

Note that a valid knight move consists of moving two squares vertically and one square horizontally, 
or two squares horizontally and one square vertically. The figure below illustrates all the possible eight moves of a knight from some cell.

https://leetcode.com/contest/weekly-contest-337/problems/check-knight-tour-configuration/
"""

class Solution:
    """
    This question are basically asking if the path of knight is valid.
    Since knight can only move the grid that are two in horizontal/vertical and one in horizontal/vertical away from the origin,
    there are only 8 possible moves can make, ignoring the boundary
    
    Therefore, we just have to check if the difference between next move and previous move belongs to a valid move.
    
    To do so, I use a dictionary (can use a list as well), to store the location of each the knight after each move.
    the dictionary is equvialent to the "grid" that pass in, but store the information in different format
    
    Follow every move and check if it is valid.
    """
    def checkValidGrid(self, grid: list[list[int]]) -> bool:
        if grid[0][0] != 0:
            return False
        
        moves = {}
        n = len(grid)
        prev_i, prev_j = 0, 0
        valid = [(1,2),(1,-2),(-1,2),(-1,-2),(2,1),(2,-1),(-2,1),(-2,-1)]
        
        for i in range(n):
            for j in range(n):
                moves[grid[i][j]] = (i, j)
                
        for i in range(1, n**2):
            if (moves[i][0] - prev_i, moves[i][1] - prev_j) not in valid:
                return False
            prev_i = moves[i][0]
            prev_j = moves[i][1]
            
        return True