package GameOfLife;

public class GameofLife {
    public void gameOfLife(int[][] board) {

        // positive >> origin alive
        // negative >> origin dead
        // 2 >> alive
        // 1 >> dead
        // ex: -1 : dead to dead, -2 : dead to alive

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if (board[x][y] == 0) board[x][y] = -1;
            }
        }
        
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board[0].length; y++) {
                int count = checkNeighbors(board, x, y);

                if(board[x][y] < 0) {
                    board[x][y] = count == 3 ? -2 : -1;
                }
                else {
                    board[x][y] = count <= 3 && count > 1 ? 2 : 1;
                }
            }
        }

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                board[x][y] = Math.abs(board[x][y]) - 1;
            }
        }

    }
    
    private int checkNeighbors(int[][] board, int x, int y){
        int count = board[x][y] > 0 ? -1 : 0;

        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(validPosition(board.length, board[0].length, x + i, y + j)){
                    count += board[x + i][y + j] > 0 ? 1 : 0;
                }
            }
        }
        
        return count;
    }
    
    private boolean validPosition(int n, int m, int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
