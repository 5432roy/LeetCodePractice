package SpiralMatrix;
import java.util.*;
public class SpiralMatrix {
    List<Integer> res;
    int[] direction = {0,1,0,-1,0};
    public List<Integer> spiralOrder(int[][] matrix){
        res = new ArrayList<Integer>();
        add(matrix, 0, 0, 0);
        return res;
    }

    public int nextDirection(int i){
        return i == 3 ? 0 : i + 1;
    }

    public void add(int[][] matrix, int i, int j, int d){
        if(res.size() == matrix.length * matrix[0].length) return;

        res.add(matrix[i][j]);
        matrix[i][j] = Integer.MIN_VALUE;
        if(i + direction[d]  < 0 || j + direction[d + 1] < 0 || i + direction[d] >= matrix.length || j + direction[d + 1] >= matrix[0].length || matrix[i + direction[d]][j + direction[d + 1]] == Integer.MIN_VALUE){
            d = nextDirection(d);
        }
            add(matrix, i + direction[d], j + direction[d + 1], d);
    }


    
}
