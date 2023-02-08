package WeeklyContest260;

public class CheckIfWordCanBePlacedInCrossWord {
    
    public boolean placeWordInCrossword(char[][] board, String str){
        int n = board.length, m = board[0].length;
        int[] direction = {0,1,0,-1,0};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == ' ' || board[i][j] == str.charAt(0)){
                    for(int k = 0; k < direction.length - 1; k++){
                        int r = i, c = j, l = 0;
                        if(valid(n, m, r - direction[k], c - direction[k + 1]) && board[r - direction[k]][c - direction[k + 1]] != '#') continue;

                        while(l < str.length() && valid(n, m, r, c)){
                            if(board[r][c] == '#' || !(board[r][c] == ' ' || board[r][c] == str.charAt(l))) break;
                            l++;
                            r += direction[k];
                            c += direction[k + 1];
                        }

                        if(l == str.length() && (!valid(n, m, r, c) || board[r][c] == '#')) return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean valid(int n, int m, int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
