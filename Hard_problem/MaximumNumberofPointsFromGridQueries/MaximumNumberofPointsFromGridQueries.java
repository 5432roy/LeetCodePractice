/*
 * 2503. Maximum Number of Points From Grid Queries
 * https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/?envType=daily-question&envId=2025-03-28
 * 
 * 
 * BFS throguh the grid
 * Update the smallest number to collect current point
 * Put the result into Map
 */

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int max = 0, n = queries.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i : queries) {
            max = Math.max(max, i);
            set.add(i);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        q.add(new int[]{0, 0, grid[0][0]});

        HashMap<Integer, Integer> seen = new HashMap<>();
        int[] res = new int[n], dir = new int[]{1,0,-1,0,1};
        int cur = 0, count = 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            if(grid[temp[0]][temp[1]] <= 0) {
                continue;
            }

            while(temp[2] >= cur) {
                if(set.contains(cur)) {
                    seen.put(cur, count);
                }
                cur++;
            }

            count++;
            grid[temp[0]][temp[1]] = 0;

            for(int i = 0; i < 4; i++) {
                if(temp[0] + dir[i] < grid.length && temp[1] + dir[i + 1] < grid[0].length &&
                   temp[0] + dir[i] >= 0 && temp[1] + dir[i + 1] >= 0) {
                    q.add(new int[]{temp[0] + dir[i], temp[1] + dir[i + 1], grid[temp[0] + dir[i]][temp[1] + dir[i + 1]]});
                }
            }
        }

        for(int i = 0; i < n; i++) {
            res[i] = seen.getOrDefault(queries[i], count);
        }
        
        return res;
    }
}