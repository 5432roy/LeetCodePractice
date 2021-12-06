package ShortestPathInAGridWithObstaclesElimination;
import java.util.*;
public class ShortestPathWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k){
        int res = 0;
        int n = grid.length, m = grid[0].length;

        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});

        int[] direction = new int[]{0,1,0,-1,0};
        while(!queue.isEmpty()){

            for(int i = queue.size(); i > 0; i--){
                int[] cur = queue.poll();
                if(cur[0] == n - 1 && cur[1] == m - 1) return res;

                for(int j = 0; j < direction.length - 1; j++){
                    int x = cur[0] + direction[j], y = cur[1] + direction[j + 1], nextK = cur[2];
                    if(!valid(grid, x, y)) continue;
                    if(grid[x][y] == 1) nextK++;
                    if(nextK <= k && !visited[x][y][nextK]){
                        visited[x][y][nextK] = true;
                        queue.offer(new int[]{x, y, nextK});
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean valid(int[][] grid, int x, int y){
        return (x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length);
    }
    
}
