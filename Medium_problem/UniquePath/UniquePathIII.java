package UniquePath;

public class UniquePathIII {

    public int uniquePathsIII(int[][] grid) {
        int sum = 1;
        int[] start = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                sum += grid[i][j] == 0 ? 1 : 0;
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j; 
                }
            }
        }
        return backTracking(grid, start[0], start[1], 0, sum);    
    }
    
    int[] direction = {0,1,0,-1,0};
    private int backTracking(int[][] grid, int r, int c, int visited, int sum){
        if(!valid(grid, r, c)) return 0;
        if(grid[r][c] == 2) return visited == sum ? 1 : 0;

        grid[r][c] = -1;

        int res = 0;
        for(int i = 0; i < direction.length - 1; i++){
            res += backTracking(grid, r + direction[i], c + direction[i + 1], visited + 1, sum);
        }

        grid[r][c] = 0;

        return res;
    }

    private boolean valid(int[][] grid, int r, int c){
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != -1;
    }
    
}
