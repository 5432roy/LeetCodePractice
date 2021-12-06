package DungeonGame;
import java.util.*;
public class DungeonGame {
    
    public int calculateMinimumHP(int[][] dungeon){
        int n = dungeon.length, m = dungeon[0].length;
        int[][] memo = new int[n][m];
        for(int[] i : memo) Arrays.fill(i, Integer.MIN_VALUE);
        int res = helper(dungeon, memo, 0, 0);
        return res < 1 ? 1 : res;
    }

    private int helper(int[][] dungeon, int[][] memo, int r, int c){
        if(!valid(dungeon, r, c)) return 1000000005;
        if(memo[r][c] != Integer.MIN_VALUE) return memo[r][c]; 
        if(r == dungeon.length - 1 && c == dungeon[0].length - 1) return dungeon[r][c] < 1 ? 1 - dungeon[r][c] : 1;

        int res = Math.min(helper(dungeon, memo, r + 1, c), helper(dungeon, memo, r, c + 1)) - dungeon[r][c];

        return memo[r][c] = res < 1 ? 1 : res;
    }

    private boolean valid(int[][] dungeon, int r, int c){
        return r < dungeon.length && r >= 0 && c < dungeon[0].length && c >= 0;
    }
}
