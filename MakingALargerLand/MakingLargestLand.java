package MakingALargerLand;
import java.util.*;
public class MakingLargestLand {

    int[] direction = {0,1,0,-1,0};
    public int largestIsland(int[][] grid){
        int res = 0;
        int key = 2;
        HashMap<Integer, Integer> lands = new HashMap<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    lands.put(key, land(grid, i, j, key));
                    res = Math.max(res, lands.get(key++));
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 0){
                    int cur = 1;
                    HashSet<Integer> connectedLands = new HashSet<>();
                    for(int k = 1; k < direction.length; k++){
                        int row = i + direction[k - 1], col = j + direction[k];
                        if(row < 0 || row >= grid.length || col < 0 || col >= grid.length) continue;
                        key = grid[row][col];
                        if(key > 1 && !connectedLands.contains(key)){
                            connectedLands.add(key);
                            cur += lands.get(key); 
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }
    private int land(int[][] grid, int row, int col, int key){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] != 1) return 0;
        int sum = 1;
        grid[row][col] = key;
        for(int i = 1; i < direction.length; i++){
            sum += land(grid, row + direction[i - 1], col + direction[i], key);
        }
        return sum;
    }
    
}
