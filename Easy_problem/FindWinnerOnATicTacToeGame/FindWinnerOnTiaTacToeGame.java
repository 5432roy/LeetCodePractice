package FindWinnerOnATicTacToeGame;

public class FindWinnerOnTiaTacToeGame {
    public String tictactoe(int[][] moves){
        String[][] memo = new String[3][3];
        boolean first = true;
        for(int[] a : moves){
            if(first){
                memo[a[0]][a[1]] = "A";
            }
            else{
                memo[a[0]][a[1]] = "B";
            }
            first = !first;
        }

        for(int i = 0; i < 3; i++){
            if(memo[i][0] == memo[i][1] && memo[i][1] == memo[i][2] && memo[i][0] != null) return memo[i][0];
            if(memo[0][i] == memo[1][i] && memo[2][i] == memo[1][i] && memo[0][i] != null) return memo[0][i];
        }
        if(memo[0][0] == memo[1][1] && memo[1][1] == memo[2][2] && memo[1][1] != null) return memo[1][1];
        if(memo[2][0] == memo[1][1] && memo[0][2] == memo[1][1] && memo[1][1] != null) return memo[1][1];
        return moves.length == 9 ? "Draw" : "Pending"; 
    }
}
