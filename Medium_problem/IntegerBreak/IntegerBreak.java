package IntegerBreak;

public class IntegerBreak {
    public int integerBreak(int n) {
        // edge case
        if(n <= 3) return n - 1;
        
        int[] memo = new int[n + 1];
        memo[1] = 1;
        return dp(n, memo);
    }
    
    private int dp(int m, int[] memo) {
        if(m <= 0) return 0;
        if(memo[m] != 0) return memo[m];
        int res = m;
        
        for(int i = 1; i < m - 1; i++) {
            res = Math.max(res, dp(m - i, memo) * dp(i, memo));
        }
        
        return memo[m] = res;
    }
}
