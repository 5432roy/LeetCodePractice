package Largest1BorderedSquare;

public class Largest1BorderedSquare {

    int largest1BorderedSquare(int[][] grid){

        int[][] ver = new int[grid.length][grid[0].length];
        int[][] hor = new int[grid.length][grid[0].length];

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    hor[r][c] = (c==0)? 1: hor[r][c-1] + 1;
                    ver[r][c] = (r==0)? 1: ver[r-1][c] + 1;
                }
            }
        }
        int max = 0;
        for(int r = grid.length - 1; r >= 0; r--){
            for(int c = grid[0].length - 1; c >= 0; c--){
                int length = Math.min(hor[r][c], ver[r][c]);

                while(length > max){
                    if(ver[r][c - length + 1] >= length && hor[r - length + 1][c] >= length)
                    max = length;
                    length--;
                }
            }
        }

        return max*max;
    }
    
}
