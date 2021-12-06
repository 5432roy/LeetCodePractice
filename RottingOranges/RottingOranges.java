package RottingOranges;
import java.util.*;
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }
        int res = 0;
        int[] direction = {0,1,0,-1,0};
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int r = queue.peek()[0], c = queue.poll()[1];
                for(int j = 0; j < direction.length - 1; j++){
                    if(valid(grid, r + direction[j], c + direction[j + 1]) && grid[r + direction[j]][c + direction[j + 1]] == 1){
                        queue.offer(new int[]{r + direction[j], c + direction[j + 1]});
                        grid[r + direction[j]][c + direction[j + 1]] = 2;
                    }
                }
            }
            if(!queue.isEmpty()) res++;
        }
        
        for(int[] nums : grid){
            for(int num : nums){
                if(num == 1) return -1;
            }
        }
        
        return res;   
    }

    private boolean valid(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
    
}
