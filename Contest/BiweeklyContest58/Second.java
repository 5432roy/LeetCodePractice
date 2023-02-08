package BiweeklyContest58;

public class Second {

    public boolean checkMove(char[][] board, int row, int col, char color) {
        for(int i = 1; i < 5; i++){
            if(dfs(board, row, col, color, 0, i)) return true;
        }
        return false;
    }
    int[] direc = {0,1,0,-1,0};
    public boolean dfs(char[][] board, int row, int col, char color, int length, int i){
        if(row < 0 || row >= 8 || col < 0 || col >= 8 || board[row][col] == '.') return false;
        if(board[row][col] == color && length == 0) return length >= 2;
        return dfs(board, row + direc[i - 1], col + direc[i], color, length + 1, i);
    }
    
}
