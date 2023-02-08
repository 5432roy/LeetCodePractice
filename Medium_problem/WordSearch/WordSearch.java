package WordSearch;

public class WordSearch {

    public boolean exist(char[][] board, String word){
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backTracking(board, new boolean[n][m], word, 0, i, j)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    int[] dir = new int[]{0,1,0,-1,0};
    private boolean backTracking(char[][] board, boolean[][] visited, String word, int index, int r, int c){
        if(index == word.length()) return true;
        if(!valid(board, r, c) || visited[r][c]) return false;
        if(!(board[r][c] == word.charAt(index))) return false;
        
        visited[r][c] = true;
        
        boolean res = false;
        for(int i = 0; i < dir.length - 1; i++){
            res = res || backTracking(board, visited, word, index + 1, r + dir[i], c + dir[i + 1]);
        }
        
        visited[r][c] = false;
        return res;
    }

    private boolean valid(char[][] board, int r, int c){
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }
    
}
