package SurroundedRegions;
import java.util.*;
public class SurroundedRegions {
    //DFS
    public static void main(String[] args){
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','O'},{'X','X','X','X'}};

        for(int i = 0; i < board.length; i++)
        System.out.println(Arrays.toString(board[i]));
        
    }
    

    public void solve(char[][] board){
        int m = board.length, n = board[0].length;
        //given that only the 'O' that connects or stays on the board can be kept as 'O'
        //start from the every board and turn every 'O' that is connected with it to '*' 
        for(int row = 0; row < m; row++){
            if(board[row][0] == 'O') dfs(board, row, 0);
            if(board[row][n - 1] == 'O') dfs(board, row, n - 1);
        }
        for(int col = 1; col < n - 1; col++){
            if(board[0][col] == 'O') dfs(board, 0, col);
            if(board[m - 1][col] == 'O') dfs(board, m - 1, col);
        }

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] == 'O') board[row][col] = 'X';
                if(board[row][col] == '*') board[row][col] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int row, int col){
        if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || board[row][col] != 'O') return;

        board[row][col] = '*';

        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);

    }
}
