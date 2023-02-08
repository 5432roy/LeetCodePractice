package Martix;
import java.util.*;
public class Matrix {

    public int[][] updateMatrix(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == 0) queue.offer(new int[]{row, col});
                else matrix[row][col] = Integer.MAX_VALUE;
            }
        }
        
        int[] direction = {0,1,0,-1,0};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int r = cur[0] + direction[i];
                int c = cur[1] + direction[i + 1];
                if(r < 0 || r >= m || c < 0 || c >= n) continue;
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cur[0]][cur[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cur[0]][cur[1]] + 1;
            }
        }

        return matrix;
    }
    
}
