package NumberOfIslands;
import java.util.*;
public class NumberOfIslands {

    public int numIslands(char[][] grid){
        int id = 0, m = grid.length, n = grid[0].length;
        int[] direction = {0,1,0,-1,0};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    grid[i][j] = '*';
                    while(!queue.isEmpty()){
                        int[] position = queue.poll();
                        for(int k = 1; k < 5; k++){
                            int row = position[0] + direction[k - 1], col = position[1] + direction[k];
                            if(valid(row, col, m, n) && grid[row][col] == 1){ 
                                queue.add(new int[]{row,col});
                                grid[row][col] = '*';
                            }
                        }        
                    }
                    id++;
                }
            }
        }
        return id;
    }

    private boolean valid(int row, int col, int m, int n){
        return !(row < 0 || row >= m || col < 0 || col >= n);
    }
    
}
