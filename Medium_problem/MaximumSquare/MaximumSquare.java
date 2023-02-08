package MaximumSquare;

public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        // 0 >> horizontal, 1 >> vertical
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][][] memo = new int [m][n][2];
        
        // edge case
        if(m == 1 || n == 1) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == '1') return 1;
                }
            }
        }
        
        memo[m - 1][n - 1][0] = memo[m - 1][n - 1][1] = matrix[m - 1][n - 1] == '1' ? 1 : 0;
        
        for(int i = m - 2; i >= 0; i--) {
            if(res == 0 && matrix[i][n - 1] == '1') res = 1;
            memo[i][n - 1][0] = matrix[i][n - 1] - '0';
            memo[i][n - 1][1] = matrix[i][n - 1] == '1' ? memo[i + 1][n - 1][1] + 1 : 0;
        }
        
        for(int i = n - 2; i >= 0; i--) {
            if(res == 0 && matrix[m - 1][i] == '1') res = 1;
            memo[m - 1][i][0] = matrix[m - 1][i] == '1' ? memo[m - 1][i + 1][0] + 1 : 0;
            memo[m - 1][i][1] = matrix[m - 1][i] - '0';
        }
        
        for(int i = matrix.length - 2; i >= 0; i--) {
            for(int j = matrix[0].length - 2; j >= 0; j--) {
                if(matrix[i][j] == '0') continue;
                memo[i][j][0] = Math.min(memo[i][j + 1][0], memo[i + 1][j + 1][0]) + 1;
                memo[i][j][1] = Math.min(memo[i + 1][j][1], memo[i + 1][j + 1][1]) + 1;
                res = Math.max(res, Math.min(memo[i][j][0], memo[i][j][1]));
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return res * res;
    }
}
