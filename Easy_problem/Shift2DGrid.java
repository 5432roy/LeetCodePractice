package Easy_problem;
import java.util.*;
public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid[0].length, n = grid.length, a = n * m;
        ArrayList<Integer> linear = new ArrayList<>();
        
        for(int[] row : grid){
            for(int col : row){
                linear.add(col);
            }
        }
        
        k = k % a;
        int i = a - k;
        for(int r = 0; r < n; r++){
            List<Integer> col = new ArrayList<>();
            for(int c = 0; c < m; c++){
                col.add(linear.get(i % a));
                i++;
            }
            res.add(col);
        }
        
        return res;
    
    }
    
}
