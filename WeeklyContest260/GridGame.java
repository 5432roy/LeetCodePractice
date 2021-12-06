package WeeklyContest260;
import java.util.*;
public class GridGame {
    public long gridGame(int[][] grid) {
        long topSum = Arrays.stream(grid[0]).asLongStream().sum(), bottomSum = 0;
        long res = Long.MAX_VALUE;

        for(int i = 0; i < grid[0].length; i++){
            topSum -= grid[0][i];
            res = Math.min(res, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }

        return res;
    }

}
