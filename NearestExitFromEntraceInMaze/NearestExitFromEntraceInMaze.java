package NearestExitFromEntraceInMaze;
import java.util.*;
public class NearestExitFromEntraceInMaze {
    public static void main(String[] args){

    }
    //BFS
    public static int nearestExit(char[][] maze, int[] entrance){
        Queue<int[]> queue = new LinkedList<>();
        int direction[] = {-1,0,1,0,-1};
        int r = 1;
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty()){
            for(int frontier = queue.size(); frontier > 0; frontier--){
                int cur[] = queue.poll();
                for(int i = 1; i < direction.length; i++){
                    int row = cur[0] + direction[i - 1], col = cur[1] + direction[i];
                    if(0 <= row && row < maze.length && 0 <= col && col < maze[0].length && maze[row][col] == '.'){
                        if(row == 0 || row == maze.length - 1 || col == 0 || col == maze[0].length - 1){
                            return r;
                        }
                        queue.offer(new int[]{row, col});
                        maze[row][col] = '+';
                    }
                }
            }
            r++;
        }

        return -1;
    }
    
}
