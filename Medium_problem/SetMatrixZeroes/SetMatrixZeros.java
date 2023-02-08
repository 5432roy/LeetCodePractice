package SetMatrixZeroes;
import java.util.*;
public class SetMatrixZeros {

    public void setZeroes(int[][] matrix){
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 0) queue.add(new int[]{row, col});
            }
        }
        
        while(!queue.isEmpty()){
            int row = queue.peek()[0], col = queue.poll()[1];
            for(int i = 0; i < direction.length - 1; i++){
                helper(matrix, row, col, i);
            }
        }
    }
    int[] direction = {0,1,0,-1,0};
    public void helper(int[][] matrix, int row, int col, int i){
        if(row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0) return;

        matrix[row][col] = 0;
        helper(matrix, row + direction[i], col + direction[i + 1], i);
    }
    
}
