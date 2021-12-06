package UniquePath;

public class Unique {

    public static void main(String[] args){

        System.out.println(uniquePaths(3, 3));

    }

    public static int uniquePaths(int m, int n){
        int[][] memo = new int[m][n];
        return paths(m - 1 , n - 1, memo) ;
    }

    public static int paths(int m, int n, int[][] memo){
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;
        if(memo[m][n] != 0) return memo[m][n];
        memo[m][n] = paths(m - 1, n, memo) + paths(m, n - 1, memo);
        return memo[m][n];
    }
    
}
