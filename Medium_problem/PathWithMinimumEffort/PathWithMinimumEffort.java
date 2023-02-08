package PathWithMinimumEffort;
import java.util.*;
public class PathWithMinimumEffort {

    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[] direction = new int[]{1,0,-1,0,1};
            
            int[][] memo = new int[m][n];
            for(int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
            
            PriorityQueue<int[]> paths = new PriorityQueue<>((a,b) -> a[0] - b[0]);
            paths.offer(new int[]{0, 0, 0});
    
            while(!paths.isEmpty()) {
                int[] cur = paths.poll();
                
                if(cur[0] > memo[cur[1]][cur[2]]) continue;
                if(cur[1] == m - 1 && cur[2] == n - 1) return cur[0];
                
                for(int i = 0; i < 4; i++) {
                    int row = cur[1] + direction[i], col = cur[2] + direction[i + 1];
    
                    if(row < 0 || col < 0 || row >= m || col >= n) continue;
                    int newDistance = Math.max(cur[0], Math.abs(heights[cur[1]][cur[2]] - heights[row][col]));
                    
                    if(memo[row][col] > newDistance) {
                        memo[row][col] = newDistance;
                        paths.offer(new int[]{newDistance, row, col});
                    }
                }
            }
            return -1;
        }
    }
    
}
