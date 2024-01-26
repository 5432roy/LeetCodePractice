/*
 * 576. Out of Boundary Paths
 * 
 * There is an m x n grid with a ball. 
 * The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). 
 * You can apply at most maxMove moves to the ball.Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. 
 * Since the answer can be very large, return it modulo 109 + 7.
 * 
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 */

class Solution {
    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 0) {
            return 0;
        }

        int memo[][][] = new int[m][n][maxMove + 1];
        int direction[] = {0,1,0,-1,0};
        helper(m, n, maxMove, startRow, startColumn, memo, direction);

        return memo[startRow][startColumn][maxMove] == Integer.MAX_VALUE ? 0 : memo[startRow][startColumn][maxMove];
    }

    // dfs until we know the amount of path for current position with the remaining moves.
    private int helper(int m, int n, int moves, int r, int c, int[][][] memo, int[] direction) {
        if(moves == -1) {
            return 0;
        }

        if(outOfBoundary(m, n, r, c)) {
            return 1;
        }

        if(memo[r][c][moves] != 0) {
            return memo[r][c][moves] == Integer.MAX_VALUE ? 0 : memo[r][c][moves];
        }

        int res = 0;

        for(int i = 0; i < 4; i++) {
            res += helper(m, n, moves - 1, r + direction[i], c + direction[i + 1], memo, direction);
            res %= MOD;
        }

        // set the memo to a non-zero value for the condition that we have visited but no possible way to get out of the boundary.
        memo[r][c][moves] = res == 0 ? Integer.MAX_VALUE : res;

        return res;
    }

    private boolean outOfBoundary(int m, int n, int r, int c) {
        return r < 0 || c < 0 || r >= m || c >= n;
    }
}