package Triangle;
import java.util.*;
public class Triangle {

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(minmumTotal(list));
    }

    public static int minmumTotal(List<List<Integer>> tri){
        int[][] dp = new int[tri.size()][tri.size()];
        dp[0][0] = tri.get(0).get(0);

        for(int i = 1; i < tri.size(); i++){
            dp[i][0] = dp[i - 1][0] + tri.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + tri.get(i).get(i);
        }

        for(int row = 2; row < tri.size(); row++){
            for(int col = 1; col < row; col++){
                dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + tri.get(row).get(col);
            }
        }
        //debug
        for(int i = 0; i < tri.size(); i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < tri.size(); i++){
            min = Math.min(min, dp[tri.size() - 1][i]);
        }
        return min;
    }
    
    // top-down dp
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][];
        for(int i = 0; i < triangle.size(); i++) {
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        helper(triangle, 0, 0, memo);
        //System.out.println(Arrays.deepToString(memo));
        return memo[0][0];
    }
    
    private int helper(List<List<Integer>> triangle, int level, int index, int[][] memo) {
        if(level >= triangle.size()) return 0 ;
        if(index > level) return Integer.MAX_VALUE;
        if(memo[level][index] != Integer.MIN_VALUE) return memo[level][index];
        return memo[level][index] = triangle.get(level).get(index) + Math.min(helper(triangle, level + 1, index, memo), helper(triangle, level + 1, index + 1, memo));
    }

    
}
