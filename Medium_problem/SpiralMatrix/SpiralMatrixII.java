package SpiralMatrix;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] direction = new int[][]{{0,1,0,-1},{1,0,-1,0}};
        int row = 0, col = 0, d = 0, count = n * n;
        
        for(int i = 1; i <= count; i++){
            res[row][col] = i;
            d = turn(row + direction[0][d], col + direction[1][d], n, res) ? (d + 1) % 4 : d;
            row += direction[0][d];
            col += direction[1][d];
        }
        
        return res;
    }
    
    private boolean turn(int row, int col, int n, int[][] matrix){
        return row < 0 || row >= n || col < 0 || col >= n || matrix[row][col] != 0;
    }
}
