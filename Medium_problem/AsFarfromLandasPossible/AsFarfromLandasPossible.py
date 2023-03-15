"""
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
https://leetcode.com/problems/as-far-from-land-as-possible/description/
"""

class Solution:
    # BFS O(n * n)
    def maxDistance(self, grid: list[list[int]]) -> int:
        n = len(grid)
        dir = [0,1,0,-1,0]
        count = sum(map(sum, grid))
        # if the entire grid is land or water
        if count == 0 or count == n ** 2:
            return -1
        # initial the queue
        queue = []
        for row in range(n):
            for col in range(n):
                if grid[row][col] == 1:
                    queue.append((row, col))

        res = 1
        # bfs
        while len(queue) > 0:
            for i in range(len(queue)):
                cur = queue.pop(0)
                for d in range(4):
                    row, col = cur[0] + dir[d], cur[1] + dir[d + 1]
                    if row < 0 or col < 0 or row >= n or col >= n:
                        continue
                    if grid[row][col] == 0:
                        grid[row][col] = res
                        queue.append((row, col))
            res += 1
        return max(map(max, grid))

    # dfs solution
    # time complextiy O(m * n * n), where n is the size of grid, and m is the number of land
    def maxDistance_TLE(self, grid: list[list[int]]) -> int:
        n = len(grid)
        dir = [0,1,0,-1,0]
        count = sum(map(sum, grid))
        if count == 0 or count == n ** 2:
            return -1
        for row in range(n):
            for col in range(n):
                if grid[row][col] == 1:
                    for i in range(4):
                        self.findland_DFS(grid, 2, row + dir[i], col + dir[i + 1])

        return max(map(max, grid)) - 1
    

    def findland_DFS(self, grid, dis, row, col):
        if row >= len(grid) or row < 0 or col >= len(grid) or col < 0:
            return
        if grid[row][col] == 1 or grid[row][col] != 0 and grid[row][col] < dis:
            return 
        
        grid[row][col] = dis

        dir = [0,1,0,-1,0]

        for i in range(4):
            self.findland_DFS(grid, dis + 1, row + dir[i], col + dir[i + 1])
        

grid = [[0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0,1,0,0,1,1,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,0,1,1,0],[1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,0,1,1,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,0,1],[0,0,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,1,1,1,1,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,0,1,0,0,0,1,1,0,0,1,1,0],[1,0,1,0,0,0,1,1,1,1,1,0,0,1,1,0,1,1,0,0,1,0,1,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,0,1,0,1,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0],[1,0,0,0,1,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,0,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,0,1,0],[0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,0,1,0,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,0,1,0,0,0,0,0,1,1,1],[0,0,1,0,1,0,0,0,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,0,1,1,0,0,1,0,1,1,0,0,1,1,1,1,1,1,0,1,0,1,0,1,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,0,1,1],[1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0],[1,0,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,0,0,0,1,1,1,0,0,1,0,0],[0,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,1,0,0,0,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,1,0,1,0,1,1,0,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,0,1,1],[1,0,0,0,0,1,1,0,0,1,0,0,1,1,0,1,0,0,0,0,1,1,0,0,1,0,0,0,1,0,0,1,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,1,1,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,1,1,0,0,1,0,0,0,0,0,1,0,1,1,1,0,1,1,0,1,0,0,1,0,1,0,1,1,1,0,0,1,1,1,0,1],[0,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,1,0,0,0,1,1,1,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,1,1,0,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,1,0,0,1],[0,1,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,1,0,0,1,1,0,0,1,0,1],[1,0,0,1,0,1,1,1,0,0,0,1,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,0,1,1,0,0,1,0,0,0,0,0,1,0,1,0,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,1,0,0],[0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,0,0,1,0,1,1,1,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,1,1,0,1,0,1,0,0,1,0,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,1,0,0,0,1],[0,0,1,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,0,1,1,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,1,0,0,0,1,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,0,1,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,1,0],[1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,0,1,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,0,1,0,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,0,0,1,0,1,0,1,1,0,0,0],[0,0,0,0,1,1,0,0,0,0,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,0,0,1,0,1,0,0,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,0,0,1,1,0,1,0,1,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,0],[1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,0],[0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1],[0,1,0,1,1,0,1,1,0,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,0,0,0,0,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,0,0,0,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,0],[0,1,1,1,0,1,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,0,1,0,1,1,1,0,1,0,0,1,0,0,0,1,1,1,1,0,1,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,0,0,0,1,1,0,0,1,1,0,1,0,0,0,1,0,0,1,0,1,1],[1,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,0,0,0,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0],[0,1,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1],[0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,1,1,0,0,1,1,1,1,0,1,0,1,0,0,1,0,0,1,1,0,0,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,0,0,1,0,0,1,1,0,1,0,1,0,1,0,0,1,1,1,0,0,1,0],[1,1,1,1,0,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,0,1,1,1,0,0,0,1,0,0,1,0,1,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,1,1,0,0,0,1,0,1,1,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1],[1,0,1,0,1,1,1,0,0,1,0,0,0,1,1,1,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,0,1,0,0,1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,1,1,1],[1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,0,0,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,0,0,1,1,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,1],[1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,1,1,0,1,0,1,0,1,1,0,1,1,1,0,0,0],[0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,0,0,1,1,0,1,0,0,0,0,1,0,0,0,1,1,0,0,0],[0,1,0,1,0,0,1,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,1,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,0,0,1,0,0,1,1,1,0,1,0,1,1,0,1,0,1,0,1,1,1,1,0,0,0,0,0,1,0,0,1],[1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,0,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,0],[0,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1,1,0],[1,1,1,1,0,0,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,0,1,0,0,0,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,0,1,1,0,1,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,1,0,0,0],[1,0,1,0,0,0,1,0,0,1,0,1,1,1,1,0,1,0,0,1,1,1,1,0,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,1,1,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,0,1],[0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,1,1,0,0,0,0,0,1,1,0,1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,0,0,1,1,0,0,0,0,1,1,1,1,0,1,1,1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,0],[0,1,1,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0,1,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0],[1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,1,1,0,1,0,1,1,1,1,0,0,1,0,0,1,0,1,0,0,0,1,1,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,1,1,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0,1,0],[0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0,1,1,0,0,1,1,0,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,1,0,1,1,1,0,1,0,0,1,1,1],[0,1,1,1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,0,1,1,1,0,1,1,1,0,1,1,0],[1,1,1,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,0,1,1,1,0,1,1,0,1,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,1,0,0,1,1,0,1,0,0,1],[0,0,1,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,1,0,1,0,0,1],[1,1,0,0,0,0,0,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,0,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1],[1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,0,1,0,0,0,0,1,1,0,0,1,0,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,1,1],[1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,0],[0,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,1,0,0,1,0,1,1,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0],[0,0,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,0,1,1,0,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,0,1,1,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,1,0,0,0,0,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1],[0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,1,1,0,0,1,1,0,1,0,1,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0,0,1,0,1,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,1,0,0,0,0],[0,1,0,0,1,1,1,0,1,1,0,0,0,0,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1],[0,0,1,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,1],[1,0,1,0,0,1,0,0,0,1,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,0,1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0],[0,1,1,0,1,1,0,1,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,1],[1,1,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,1,1,1,1,0,1,0,0,1,0,0,1,0],[0,0,1,1,1,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,1,1,0,1,0,0,1,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,0,1],[1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1,1,0,1,1,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,1,0,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,0,1,1,0],[1,0,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,0,1,1,1,0,1],[1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,1,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,1,0,0,1,0,1,0,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,1,0],[1,1,1,1,1,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,1,1,0,1,1],[1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,1,0,0,0,1,0,1,1,1,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,0,0,1,1,1,0,1,0,0,1,1,1,0,1,0,0,0,1,1,0,1,0,0,1,0,1,0,0,0,0,1,1,0,0],[0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,0,0,0,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,1,0,0,0,0,1,0,1,0,0,0,1,1,1,0,1,0,0,1,1,0,1,0,1,1,1],[0,0,1,0,1,1,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,1,1,0,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,1,1,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,0,1,0,0,0],[1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,1,0,0,0,0,1,1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,0,1,0],[0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,0,1,0,1,0,0,1,1,1,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1],[0,0,1,0,1,0,1,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,0,1,1,0,0,1,1,1,0,1,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,1,1,1,0,1,1,0,0,0],[1,1,0,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,1,0,0,0,1,1,1,0,1,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1],[0,1,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,1,0,1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,1,0,1,0],[1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,1,1,1,1,1,1,0,1,0,1],[0,1,1,0,1,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,0,0,0,1,0,1,1,0,1,0,1,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,0,0,1,1,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,0,0],[1,0,1,1,1,1,0,1,0,1,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0,1,1,0,1,0,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,0,1,0,1,1,0,0,0,1,1,1,0,0,0,0,0,1],[0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,1,0,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,0,0],[1,0,1,0,0,1,1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,0,0,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1,0,0,0,0],[1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,0,1,0,0,0,1,1,1,0,0,1,0,0,1,0,1,1,0,1,0,0,1,0],[1,1,1,0,1,1,0,0,1,1,0,1,1,0,0,1,0,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1,0,1,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,1,0,1,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0],[0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,0,0,0,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1],[0,0,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,0,0,0,1,0,1,1,0,1,0,1,1,1,0,1,0,0,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,0,1,1,1,1,1,0,0,0],[1,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,1,0,0,0,0,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1,0,0,0,1,0,1],[0,1,0,0,0,0,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0,1,1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,0],[0,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,1,1,0,0,1,0,1,1,0,0,1,1,0,1,0,0,0,0,1,0,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1],[1,0,1,1,0,0,1,1,1,0,0,0,1,0,0,1,0,0,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,0,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,0,1,0,1,1,0,1,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,0,0],[1,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,0,1,0,0,1,1,1,1,1],[1,0,0,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,0,0,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,0,1,1,0,1,0,0,1],[0,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,0,0,1,0],[1,1,1,0,0,1,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,1,0,0,0,0,1,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,1,0,0,0,0],[1,0,1,1,1,1,0,1,0,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,1,0,0,1,0,1,0,0,0,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,0,0,1,0,0,1,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,1,1,1,0,1,0],[0,1,1,1,1,0,1,0,0,0,1,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,0,0,1,1,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,1,0,1,0,0,0,0,1,0,0,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,1],[1,0,1,1,1,1,0,0,1,1,0,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,0,0,1,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0],[1,1,0,0,1,1,1,0,0,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,0,1,0,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,0,1,0,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,0,1,1,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1],[1,1,1,1,1,1,1,0,0,1,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,0,1,0,0,0,1,1,1,0,0,0,0,1,0,1,1,1,0,0,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,1],[1,1,1,0,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,1,1,0,0,0,1,0,0,1,1,1,0,1,0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,1,0,0,0,0,0,1],[1,0,0,0,0,1,1,0,1,1,0,0,1,1,1,1,0,0,1,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,0,1,0,0,1,0,1,0,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,1,0,1,0,1,1,1,1],[0,0,1,1,1,0,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,0,1,0,1,1,0,0,1,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1,0,0,0,0,0,1,0,1,1,0,1,0,1,1,1,0,0,1,1,1,1,1,1,0,1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,1,0,0,1,1,0,1,1,1],[1,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,1,0,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1],[1,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,1,1,1,0,0,1,1,0,0,1,0,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,1,0,0],[0,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,0,0,1,1,0,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,1,0,0,1,1,0,1,0,1,0,1,0,0,1,1,0,1,1,0,0,0,1,1,1,0,1,1,1,1,0,1,0,1],[1,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,1,0,1,0,0,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1],[1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,0,1,1,0,0,1,1,0,0,1,0,0,0,0,0,1,0,0],[1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,1,1,0,0,1,1],[0,1,1,0,0,1,0,1,0,1,0,0,0,1,0,0,1,0,1,1,1,0,1,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,1,0,1,1,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,1,1,0,1,0,0,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,0],[1,0,0,0,1,0,0,1,0,1,1,0,1,0,1,1,1,1,0,0,1,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,0,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,1,1],[1,0,0,0,1,1,1,1,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,1,1,0,0,1,1,0,0,1,0,0,1,1,0,1,0,1,0,1,0,1,1,0,0,1,0,0,1,0,0,0,1,0]]

        
print(Solution().maxDistance(grid))
