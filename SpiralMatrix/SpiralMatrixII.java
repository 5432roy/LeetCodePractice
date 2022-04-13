package SpiralMatrix;

public class SpiralMatrixII {
    
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] direction = new int[][]{{0,1,0,-1},{1,0,-1,0}};
        int x = 0, y = 0, d = 0, count = n * n;
        
        for(int i = 1; i <= count; i++){
            res[x][y] = i;
            d = turn(x + direction[0][d], y + direction[1][d], n, res) ? (d + 1) % 4 : d;
            x += direction[0][d];
            y += direction[1][d];
        }
        
        return res;
    }
    
    private boolean turn(int x, int y, int n, int[][] matrix){
        return x < 0 || x >= n || y < 0 || y >= n || matrix[x][y] != 0;
    }
}
