package WeeklyContest262;
import java.util.*;
public class MinimumOperationstoMakeaUniValueGrid {

    public static void main(String[] args){
        System.out.println(931 % 73);
    }

    public int minOperations(int[][] grid, int x) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        int mod = -1;
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                list.add(grid[i][j] / x);
                if(mod == -1) mod = grid[i][j] % x;
                if(mod != -1 && grid[i][j] % x != mod){
                    return -1;
                }
                grid[i][j] /= x;
            }
        }

        Collections.sort(list);
        int mid = list.get(list.size() / 2);
        for(int i : list){
            res += Math.abs(i - mid);
        }

        return res;
    }
}
